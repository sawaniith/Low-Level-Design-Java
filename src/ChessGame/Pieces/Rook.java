package ChessGame.Pieces;

import ChessGame.ChessBoard;
import ChessGame.Color;

public class Rook extends Piece {
    //Hathi
    public Rook(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(ChessBoard chessBoard, int destRow, int destCol) {
        return (row == destRow || col == destCol);
    }
}