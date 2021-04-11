package com.sdeskills.tictactoe.player;

import com.sdeskills.tictactoe.Constants;
import com.sdeskills.tictactoe.TicTacToeBoard;
import com.sdeskills.tictactoe.minmax.TicTacToeMinmax;
import com.sdeskills.utils.Pair;

public class ComputerPlayer extends Player {
    private TicTacToeMinmax aiTechnique;

    public ComputerPlayer() {
        super();
        playerSymbol = Constants.BOARD_CIRCLE_VALUE;
        aiTechnique = new TicTacToeMinmax();
    }

    public Pair<Integer, Integer> getNextMove(TicTacToeBoard board) {
        return this.searchBestMove(board);
    }

    private Pair<Integer, Integer> searchBestMove(TicTacToeBoard board) {
        int bestMove = Integer.MAX_VALUE;
        Pair<Integer, Integer> nextMove = new Pair<>();
        for(int i = 1; i <= board.getRowSize(); i++) {
            for(int j = 1; j <= board.getColSize(); j++) {
                if(board.isCellEmpty(i, j)) {
                    board.setCell(i, j, this.playerSymbol);
                    int algoVal = aiTechnique.heuristicValue(board, 0, false);
                    board.setCell(i, j, Constants.BOARD_EMPTY_VALUE);
                    if(algoVal < bestMove) {
                        bestMove = algoVal;
                        nextMove.setFirst(i);
                        nextMove.setSecond(j);
                    }
                }
            }
        }

        return nextMove;
    }
}
