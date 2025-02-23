package TicTacToe;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1, player2, currentPlayer;
    private Scanner scanner;

    public Game(String player1Name, String player2Name) {
        this.board = new Board();
        this.player1 = new Player(player1Name, 'X');
        this.player2 = new Player(player2Name, 'O');
        this.currentPlayer = player1;
        this.scanner = new Scanner(System.in);
    }

    public void switchTurn() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void start() {
        System.out.println("Welcome to Tic Tac Toe!");
        board.printBoard();

        while (true) {
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + "), enter row and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!board.placeSymbol(row, col, currentPlayer.getSymbol())) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            board.printBoard();

            if (board.checkWinner(currentPlayer.getSymbol())) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            if (board.isFull()) {
                System.out.println("It's a draw!");
                break;
            }

            switchTurn();
        }
    }
}
