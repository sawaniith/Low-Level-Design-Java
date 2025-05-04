package DesignChessGame.Pieces;

import DesignChessGame.ChessBoard;
import DesignChessGame.Color;

public class Knight extends Piece {
    //Ghora
    public Knight(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(ChessBoard chessBoard, int destRow, int destCol) {
        int rowDiff = Math.abs(destRow - row);
        int colDiff = Math.abs(destCol - col);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}
