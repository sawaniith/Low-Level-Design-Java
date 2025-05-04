package DesignChessGame;

import DesignChessGame.Pieces.*;

public class ChessBoard {
    private final Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize white pieces
        board[0][0] = new Rook(Color.WHITE, 0, 0);
        board[0][1] = new Knight(Color.WHITE, 0, 1);
        board[0][2] = new Bishop(Color.WHITE, 0, 2);
        board[0][3] = new Queen(Color.WHITE, 0, 3);
        board[0][4] = new King(Color.WHITE, 0, 4);
        board[0][5] = new Bishop(Color.WHITE, 0, 5);
        board[0][6] = new Knight(Color.WHITE, 0, 6);
        board[0][7] = new Rook(Color.WHITE, 0, 7);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Color.WHITE, 1, i);
        }

        // Initialize black pieces
        board[7][0] = new Rook(Color.BLACK, 7, 0);
        board[7][1] = new Knight(Color.BLACK, 7, 1);
        board[7][2] = new Bishop(Color.BLACK, 7, 2);
        board[7][3] = new Queen(Color.BLACK, 7, 3);
        board[7][4] = new King(Color.BLACK, 7, 4);
        board[7][5] = new Bishop(Color.BLACK, 7, 5);
        board[7][6] = new Knight(Color.BLACK, 7, 6);
        board[7][7] = new Rook(Color.BLACK, 7, 7);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(Color.BLACK, 6, i);
        }
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    public boolean isValidMove(Piece piece, int destRow, int destCol) {
        if (piece == null || destRow < 0 || destRow > 7 || destCol < 0 || destCol > 7) {
            return false;
        }
        Piece destPiece = board[destRow][destCol];
        return (destPiece == null || destPiece.getColor() != piece.getColor()) &&
                piece.canMove(this, destRow, destCol);
    }

    public boolean isCheckmate(Color color) throws NullPointerException{
        // Checkmate occurs when the King is in check and there are no valid moves to get the King out of check.
        // Get the King of the player
        Piece king = getKing(color);

        // If the King is not in check, it's not checkmate
        if (!isInCheck(color, this)) {
            return false;
        }

        // Check if any legal moves are available for the King to escape check
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (king.canMove(this, row, col)) {
                    // Try moving the King to a valid square
                    Piece targetPiece = board[row][col];
                    board[king.getRow()][king.getCol()] = null;
                    board[row][col] = king;

                    // Check if the King is still in check after the move
                    if (!isInCheck(color, this)) {
                        // Restore the original position
                        board[row][col] = targetPiece;
                        board[king.getRow()][king.getCol()] = king;
                        return false;  // King can escape check
                    }

                    // Restore the original position
                    board[row][col] = targetPiece;
                    board[king.getRow()][king.getCol()] = king;
                }
            }
        }

        // If no valid moves were found, it's checkmate
        return true;
    }

    public boolean isStalemate(Color color) {
        // Stalemate occurs when the player whose turn it is has no legal moves and their King is not in check.
        // If the King is in check, it cannot be a stalemate
        if (isInCheck(color, this)){
            return false;
        }

        // Check if the player has any legal move (for any piece)
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.getColor() == color) {
                    // Check if this piece has any legal move
                    for (int destRow = 0; destRow < 8; destRow++) {
                        for (int destCol = 0; destCol < 8; destCol++) {
                            if (piece.canMove(this, destRow, destCol)) {
                                return false;  // The player has at least one legal move
                            }
                        }
                    }
                }
            }
        }

        // If no legal move was found, it's stalemate
        return true;
    }

    private boolean isInCheck(Color color, ChessBoard chessBoard) {
        // Check if the player's King is in check (implementation depends on your board setup)
        Piece king = getKing(color);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.getColor() != color && piece.canMove(chessBoard, king.getRow(), king.getCol())) {
                    return true;  // King is in check
                }
            }
        }
        return false;  // King is not in check
    }

    private Piece getKing(Color color) {
        // Find the King's position on the board
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.getColor() == color && piece instanceof King) {
                    return piece;
                }
            }
        }
        return null;  // King not found (error handling)
    }
}