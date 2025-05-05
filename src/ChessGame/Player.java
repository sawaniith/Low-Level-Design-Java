package ChessGame;

import ChessGame.Pieces.Piece;

public class Player {
    private final Color color;

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void makeMove(ChessBoard chessBoard, Move move) {
        Piece piece = move.getPiece();
        int destRow = move.getDestRow();
        int destCol = move.getDestCol();

        if (chessBoard.isValidMove(piece, destRow, destCol)) {
            int sourceRow = piece.getRow();
            int sourceCol = piece.getCol();
            chessBoard.setPiece(sourceRow, sourceCol, null);
            chessBoard.setPiece(destRow, destCol, piece);
            piece.setRow(destRow);
            piece.setCol(destCol);
        } else {
            throw new InvalidMoveException("Invalid move!");
        }
    }
}
