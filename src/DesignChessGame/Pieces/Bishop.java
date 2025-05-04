package DesignChessGame.Pieces;

import DesignChessGame.ChessBoard;
import DesignChessGame.Color;

public class Bishop extends Piece {
    //Oot
    public Bishop(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(ChessBoard chessBoard, int destRow, int destCol) {
        int rowDiff = Math.abs(destRow - row);
        int colDiff = Math.abs(destCol - col);
        return (rowDiff == colDiff);
    }
}
