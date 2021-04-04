package com.sdeskills.tictactoe.minmax;

import com.sdeskills.tictactoe.Constants;
import com.sdeskills.tictactoe.TicTacToeBoard;

public class TicTacToeMinmax {

    public int heuristicValue(TicTacToeBoard board, int depth, boolean minimize) {
        int hval = 0;

        if (board.hasWonGame(Constants.BOARD_CROSS_VALUE)) {
            return Constants.WIN_POINT;
        } else if (board.hasWonGame(Constants.BOARD_CIRCLE_VALUE)) {
            return Constants.LOSE_POINT;
        } else if (!board.hasMovesLeft()) {
            return 0;
        }

        if (minimize) {
            for (int i = 1; i <= board.getRowSize(); i++) {
                for (int j = 1; j <= board.getColSize(); j++) {
                    if (board.isCellEmpty(i, j)) {
                        board.setCell(i, j, Constants.BOARD_CIRCLE_VALUE);
                        hval = Math.max(hval, heuristicValue(board, depth + 1, !minimize));
                        board.setCell(i, j, Constants.BOARD_CIRCLE_VALUE);
                    }
                }
            }
        } else {
            hval = Integer.MIN_VALUE;
            for (int i = 1; i <= board.getRowSize(); i++) {
                for (int j = 1; j <= board.getColSize(); j++) {
                    if (board.isCellEmpty(i, j)) {
                        board.setCell(i, j, Constants.BOARD_CROSS_VALUE);
                        hval = Math.max(hval, heuristicValue(board, depth + 1, !minimize));
                        board.setCell(i, j, Constants.BOARD_EMPTY_VALUE);
                    }
                }
            }
        }

        return hval;
    }
}
