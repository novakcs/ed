package chessdesktop;

//import Chess.ChessBoard;
import Chess.ChessPiece;
import Chess.PiecePosition;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FXMLDocumentController implements Initializable {
	
	ChessBoardRenderer board = new ChessBoardRenderer();

	@FXML
	private Label label;
	@FXML
	private Canvas canvas;
	
	@FXML
	private void handleButtonAction(ActionEvent event) {
		board = new ChessBoardRenderer();
		board.draw(canvas);
	}
	
	@FXML
	private void handleSaveButtonAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Game");
		File file = fileChooser.showSaveDialog(null);
		if (file != null) {
			Charset charset = Charset.forName("US-ASCII");                        
			//String s = "hello";
                        // Aquí empieza mi modificación
                        /* Voy a generar un fichero txt guardando 64 carácteres
                        *  con la inicial de cada ficha, mayuscula si es Blanca y minuscula si es negra
                        *  si es una casilla vacía una V - Luego para cargar haré la inversa
                        */
                        String s = "";
                        
                        // Recupero el tablero que tiene las fichas
                        Chess.ChessBoard tablero = board.getBoard();
                        //Recorro las fichas, y guardo el caracter en función de la ficha que hay
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                ChessPiece pieza = tablero.getPiece(i,j);
                                // guardo su color
                                if (pieza != null) {
                                    boolean blanco;
                                    switch(pieza.getColor()){
                                        case WHITE:
                                            blanco = true;
                                            break;
                                        default:
                                            blanco = false;
                                            break;
                                    }
                                    switch(pieza.getType()){
                                        //KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN
                                        case KING:                
                                            //Averiguo el color   

                                            if(blanco) // Si es blanco agrego la K mayuscula, si es negro minuscula
                                                s += "K";
                                            else s += "k";
                                            break;

                                        case QUEEN:                
                                            //Averiguo el color   

                                            if(blanco) // Si es blanco agrego  mayuscula, si es negro minuscula
                                                s += "Q";                                            
                                            else s += "q";
                                            break;
                                        case ROOK:                
                                             if(blanco) 
                                                // Si es blanco agrego  mayuscula, si es negro minuscula
                                                s += "R";                                            
                                            else s += "r";
                                            break;
                                        case BISHOP:                
                                            if(blanco)  // Si es blanco agrego  mayuscula, si es negro minuscula
                                                s += "B";                                           
                                            else s += "b";
                                            break;
                                        case KNIGHT:                
                                            if(blanco) // Si es blanco agrego  mayuscula, si es negro minuscula
                                                s += "N"; //Pongo N porque la K ya la usa el rey                                            
                                            else s += "n";
                                            break;
                                        case PAWN:                
                                            if(blanco) // Si es blanco agrego  mayuscula, si es negro minuscula
                                                s += "P";                                            
                                            else s += "p";
                                            break;
                                        default:   
                                            break;
                                    }    
                                }   
                                else s += "V";                                
                            }
                        
                        }
                        
			try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), charset)) {
				writer.write(s, 0, s.length());
			} 
			catch (IOException x) {
				System.err.format("IOException: %s%n", x);
			}
		}
	}

	@FXML
	private void handleLoadButtonAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		//fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Chess Files", "*.chess.xml"));
                fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Chess Files", "*"));
		File selectedFile = fileChooser.showOpenDialog(null);
		if (selectedFile != null) {
			try {
				Scanner in = new Scanner(selectedFile);
                                while (in.hasNextLine()) {
				String linea = in.nextLine(); 	// Guardamos la linea en un String
                                
                                //Recorro las 64 casillas
                                for (int i = 0; i < 64; i++) {
                                        switch(linea.charAt(i)){
                                            case 'K': // Rey blanco
                                                //me falta averiguar como cargar la pieza
                                                break;
                                        }
                                    }
		}
				
			} catch (IOException ex) {
				Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
			}

			board.draw(canvas);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		board.draw(canvas);
		
		canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			Chess.ChessPiece piece = board.getPieceAt(canvas, e.getX(), e.getY());
			if (board.getMovingPiece() == piece) {
				board.setMovingPiece(null);
				board.draw(canvas);
				return;
			}
			if (board.getMovingPiece() == null) {
				board.setMovingPiece(piece);
				board.draw(canvas);
				return;
			}
			if (board.movePieceTo(canvas, e.getX(), e.getY())) {
				board.setMovingPiece(null);
				board.draw(canvas);
				if (!board.containsKing(ChessPiece.Color.BLACK) || !board.containsKing(ChessPiece.Color.WHITE)) {
					if (!board.containsKing(ChessPiece.Color.BLACK))
						label.setText("Ganan las blancas");
					else
						label.setText("Ganan las negras");
				}
			}
		});
	}	
	
}
