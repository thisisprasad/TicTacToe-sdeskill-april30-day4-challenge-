import com.sdeskills.tictactoe.TicTacToeBoard;
import com.sdeskills.tictactoe.player.ComputerPlayer;
import com.sdeskills.tictactoe.player.HumanPlayer;
import com.sdeskills.tictactoe.player.Player;
import com.sdeskills.utils.Pair;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        startGame();
    }

    private static void startGame() {
        System.out.println("Starting game...");
        System.out.println("Player 1 - Human - X");
        System.out.println("Player 2 - Computer - O");
        System.out.println("Human player goes first...");
        playGame();
        System.out.println("Game finished...");
    }

    private static void playGame() {
        char choice = 'y';
        while(choice == 'y' || choice == 'Y') {
            System.out.println("-----------------------------------------------");
            System.out.println("START GAME");
            System.out.println("-----------------------------------------------");
            HumanPlayer humanPlayer = new HumanPlayer();
            ComputerPlayer computerPlayer = new ComputerPlayer();
            TicTacToeBoard board = new TicTacToeBoard();
            boolean humanPlayerTurn = true;
            board.print();
            while (board.hasMovesLeft()) {
                if (humanPlayerTurn) {
                    Pair<Integer, Integer> humanNextMove = humanPlayer.getNextHumanMove(board);
                    board.setCell(humanNextMove.getFirst(), humanNextMove.getSecond(), humanPlayer.getPlayerSymbol());
                } else {
                    System.out.println("Computer playing...");
                    Pair<Integer, Integer> computerNextMove = computerPlayer.getNextMove(board);
                    board.setCell(computerNextMove.getFirst(), computerNextMove.getSecond(), computerPlayer.getPlayerSymbol());
                }
                board.print();
                if (board.hasWonGame(humanPlayer.getPlayerSymbol())) {
                    System.out.println("Player 1 - Human has won");
                    break;
                } else if (board.hasWonGame(computerPlayer.getPlayerSymbol())) {
                    System.out.println("Player 2 - Computer has won");
                    break;
                }
                humanPlayerTurn = !humanPlayerTurn;
            }

            System.out.print("Game over. Do you want to play again(Y/N): ");
            choice = sc.nextLine().charAt(0);
        }
    }
}
