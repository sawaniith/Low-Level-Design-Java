package TicTacToe;

import java.util.Scanner;

public class TTTMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player 1 name: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter Player 2 name: ");
        String player2Name = scanner.nextLine();

        Game game = new Game(player1Name, player2Name);
        game.start();
    }
}
