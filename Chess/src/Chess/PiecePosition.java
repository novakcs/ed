package Chess;

public class PiecePosition {

	/** Devuelve true si la columna y fila son números entre el 0 y el 7
	 *  Si no, devuelve false
	 */
	public static boolean isAvailable(int column, int row) {
		return column >= 0 && column < 8 && row >= 0 && row < 8;
	}

	/** Comprueba si está disponible la casilla con un determinado incremento en número.
	 *  Por ejemplo si está en la casilla 6-6  y el incremento es 3-3  pues como el resultado es 9-9 y esa casilla
         * no existe, lo comprueba con la función anterior y devuelve false.
         * Si es una casilla válida, devuelve true
	 */ 
	static boolean isAvailable(PiecePosition position, int columnIncrement, int rowIncrement) {
		if (position == null)
			return false;
		
		int newColumn = position.getColumn() + columnIncrement;
		int newRow = position.getRow() + rowIncrement;
		return isAvailable(newColumn, newRow);
	}

	/** Esta comprueba si la posición de una pieza es correcta.
	 * Si es null, devuelve que no(false)
         * Si no es null, comprueba la columna y fila y comprueba con la primera función 
         * si está dentro del rango permitido (entre 0 y 7)
         * 
	 */
	static boolean isAvailable(PiecePosition position) {
		if (position == null)
			return false;
		return isAvailable(position.getColumn(), position.getRow());
	}
        // Parámetros de la clase PiecePosition
	private int column, row;

	/**
	 * Constructor en el que se especifica la columna y la fila
         * y se asignan
	 */
	public PiecePosition(int column, int row) {
		this.column = column;
		this.row = row;
	}
	
	/**
	 * Devuelve la columna
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Devuelve la fila
	 */
	public int getRow() {
		return row;
	}
	
	public boolean setValues(int column, int row) {
		if (isAvailable(column, row)) {
			this.column = column;
			this.row = row;			
			return true;
		}
		return false;
	}
	
	/** Este método es para mover la pieza, primero comprueba que sea una casilla disponible.
	 * 
	 */
	public PiecePosition getDisplacedPiece(int columnCount, int rowCount) {		
		if (!isAvailable(this, columnCount, rowCount))
			return null;
		int newColumn = getColumn() + columnCount;
		int newRow = getRow() + rowCount;
		return new PiecePosition(newColumn, newRow);
	}
	
	/** Este método clona la pieza
	 * 
	 */
	public PiecePosition clone() {
		return new PiecePosition(column, row);
	}
	
	/** Comprueba si la pieza que se envía como parámetro es la misma que la del objeto
	 * 
	 */
	public boolean equals(PiecePosition aPosition) {
		return aPosition.getColumn() == getColumn() && aPosition.getRow() == getRow();
	}
}
