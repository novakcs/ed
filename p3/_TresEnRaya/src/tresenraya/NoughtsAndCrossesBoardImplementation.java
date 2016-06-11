package tresenraya;

public class NoughtsAndCrossesBoardImplementation implements NoughtsAndCrossesBoard{
    
    Color[][] tablero = new Color[3][3];
    //boolean acabado = false;
    
    
    NoughtsAndCrossesBoardImplementation(){
        tablero[0][0] = Color.RED;
        tablero[1][0] = Color.VOID;
        tablero[2][0] = Color.WHITE;
        tablero[0][1] = Color.WHITE;
        tablero[1][1] = Color.RED;
        tablero[2][1] = Color.VOID;
        tablero[0][2] = Color.RED;
        tablero[1][2] = Color.VOID;
        tablero[2][2] = Color.WHITE;
    }

    @Override
    public boolean isGameOver() {
        
        //Recorro horizontal:           
        for (int i = 0; i <= 2; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2] && tablero[i][0] != Color.VOID) return true;                          
        }
        
        //Ahora vertical
        for (int i = 0; i <= 2; i++) {
            if (tablero[0][i] == tablero[1][i] && tablero[0][i] == tablero[2][i] && tablero[0][i] != Color.VOID)  return true;
                          
        }
        // Ahora las dos diagonales
        if (tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2] && tablero[0][0] != Color.VOID)  return true;
              
        else if (tablero[2][0] == tablero[1][1] && tablero[2][0] == tablero[0][2] && tablero[2][0] != Color.VOID) return true;
        
        return false;
    }

    @Override
    public boolean movePiece(int fromX, int fromY, int toX, int toY) {
        
        if (toX >= 0 && toX <= 2 && toY >= 0 && toY <= 2) {
            if (tablero[toX][toY] == Color.VOID) {
                tablero[toX][toY] = tablero[fromX][fromY];
                tablero[fromX][fromY] = Color.VOID;       
                return true;
                }
            else return false;
                    
        }
        else  return false;      
    }

    @Override
    public Color getPieceAt(int x, int y) {
        if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
            return(tablero[x][y]);
        }
        return Color.VOID;
    }

    @Override
    public boolean canMovePieceAt(int x, int y) {
        
        /* Comento esto, porque este método no es necesario y por lo tanto devolveré siempre true
        if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
            if (tablero[x][y] == Color.VOID) {
                return true;       
                }
        }
        return false;
        */
        return true;
    }
}