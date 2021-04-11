package com.sdeskills.tictactoe.player;

import com.sdeskills.tictactoe.Constants;
import com.sdeskills.tictactoe.TicTacToeBoard;
import com.sdeskills.utils.Pair;

import java.util.Scanner;

public class HumanPlayer extends Player {

    Scanner sc;

    public HumanPlayer() {
        super();
        sc = new Scanner(System.in);
        playerSymbol = Constants.BOARD_CROSS_VALUE;
    }

    public Pair<Integer, Integer> getNextHumanMove(TicTacToeBoard board) {
        Pair<Integer, Integer> nextMove = new Pair<>();
        while (true) {
            System.out.print("Enter cell position (x, y) as two space-separated integers: ");
            String[] cellPos = sc.nextLine().split(" ");
            int x = Integer.parseInt(cellPos[0]);
            int y = Integer.parseInt(cellPos[1]);
            if (board.validateCellPosition(x, y) && board.isCellEmpty(x, y)) {
                nextMove.setFirst(x);
                nextMove.setSecond(y);
                break;
            } else {
                System.out.println("Invalid position. Please enter again!");
            }
        }

        return nextMove;
    }

}
