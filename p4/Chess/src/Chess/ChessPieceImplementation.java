package Chess;

public class ChessPieceImplementation implements ChessPiece{
    Color color;
    Type tipo;
    boolean movida = false;
    
    ChessPieceImplementation(Color color, Type tipo){
        this.color = color;
        this.tipo = tipo;
    }
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Type getType() {
        return tipo;
    }

    @Override
    public void notifyMoved() {
        // No sé si habrá que hacer esto
        movida = true;
    }

    @Override
    public boolean wasMoved() {
        return movida;
    }

    @Override
    public PiecePosition[] getAvailablePositions(ChessBoard aBoard) {
        ChessPiece pieza;
        switch(getType()){
            //KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN
            case KING:                
                return ChessMovementManager.getAvailablePositionsOfKing(this,aBoard);
            case QUEEN:
                return ChessMovementManager.getAvailablePositionsOfQueen(this,aBoard);
            case ROOK:
                return ChessMovementManager.getAvailablePositionsOfRook(this,aBoard);
            case BISHOP:
                return ChessMovementManager.getAvailablePositionsOfBishop(this,aBoard);
            case KNIGHT:
                return ChessMovementManager.getAvailablePositionsOfKnight(this,aBoard);
            case PAWN:
                return ChessMovementManager.getAvailablePositionsOfPawn(this,aBoard);
            default:                
                return null;
        }
    }    
}