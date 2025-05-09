package ChessGame.Pieces;

import ChessGame.ChessBoard;
import ChessGame.Color;

public class Queen extends Piece {
    public Queen(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(ChessBoard chessBoard, int destRow, int destCol) {
        int rowDiff = Math.abs(destRow - row);
        int colDiff = Math.abs(destCol - col);
        return (rowDiff == colDiff) || (row == destRow || col == destCol);
    }
}