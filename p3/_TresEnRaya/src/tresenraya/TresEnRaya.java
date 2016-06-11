package tresenraya;

import java.util.Scanner;

/**
 * Esta es una version del tres en raya. La diferencia con el juego original es 
 * que el tablero empieza ya con todas las fichas en el tablero y mueven las rojas.
 * Las fichas se representan con una R las rojas, con una B las blancas, y con 
 * una V la casilla vacía
 * El tablero empieza así:
 * R  V  B
 * B  R  V
 * R  V  B
 */

public class TresEnRaya {
	
	final static int FORCE_EXIT_CODE = 1000;
	
	static NoughtsAndCrossesBoard	createBoard() {
		return new NoughtsAndCrossesBoardImplementation();
	}
	
	static void printBoard(NoughtsAndCrossesBoard aBoard) {
		System.out.print("   ");
		for (int x = 0; x < 3; x++)
			System.out.print(" " + (x + 1) + " ");
		System.out.println();

		for (int y = 2; y >= 0; y--) {

			System.out.print(" " + (y + 1) + " ");
	
			for (int x = 0; x < 3; x++) {
				
				switch(aBoard.getPieceAt(x, y)) {
					case RED: System.out.print(" R "); break;
					case WHITE: System.out.print(" B "); break;
					case VOID: System.out.print("   "); break;
				}
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}

	public static void main(String[] args) {
		NoughtsAndCrossesBoard board = createBoard();
		NoughtsAndCrossesBoard.Color currentColor = NoughtsAndCrossesBoard.Color.RED;
		Scanner keyboard = new Scanner(System.in);
		boolean forceExit = false;
		
		System.out.println("Bienvenido al juego de las res en raya, mueven las rojas");
		while (!board.isGameOver() && !forceExit) {
			printBoard(board);
			
			while (true) {
				if (currentColor == NoughtsAndCrossesBoard.Color.RED)
					System.out.println("Mueven las rojas");
				else
					System.out.println("Mueven las blancas");
				System.out.print("Diga la X de la ficha que quiera mover: ");
				int x = keyboard.nextInt() - 1;
				System.out.println("Has introducido " + (x + 1));
				if (x == FORCE_EXIT_CODE - 1) {
					forceExit = true;
					break;
				}
				System.out.print("Diga la Y de la ficha que quiera mover: ");
				int y = keyboard.nextInt() - 1;
				System.out.println("Has introducido " + (y + 1));
				if (y == FORCE_EXIT_CODE - 1) {
					forceExit = true;
					break;
				}
				
				if (board.getPieceAt(x, y) == currentColor && board.canMovePieceAt(x, y)) {
					while (true) {
						System.out.print("Diga la X de la casilla a la que quiera mover: ");
						int dx = keyboard.nextInt() - 1;
						System.out.println("Has introducido " + (dx + 1));
						if (dx == FORCE_EXIT_CODE - 1) {
							forceExit = true;
							break;
						}
						System.out.print("Diga la Y de la casilla a la que quiera mover: ");
						int dy = keyboard.nextInt() - 1;
						System.out.println("Has introducido " + (dy + 1));
						if (dy == FORCE_EXIT_CODE - 1) {
							forceExit = true;
							break;
						}

						if (board.movePiece(x, y, dx, dy))
							break;
						else 
							System.out.println("No eligió una calda correcta");
					}
					break;
				}
				else
					System.out.println("No eligió una calda correcta");
			}
			if (currentColor == NoughtsAndCrossesBoard.Color.RED)
				currentColor = NoughtsAndCrossesBoard.Color.WHITE;
			else
				currentColor = NoughtsAndCrossesBoard.Color.RED;			
		}
		if (forceExit)
			System.out.println("Salida forzada");
		else {
			printBoard(board);
			if (currentColor == NoughtsAndCrossesBoard.Color.RED)
				System.out.println("Ganan las blancas!!");
			else
				System.out.println("Ganan las rojas!!");
		}
	}
	
}
