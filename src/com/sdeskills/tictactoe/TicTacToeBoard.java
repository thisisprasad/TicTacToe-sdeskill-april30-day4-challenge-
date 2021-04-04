package com.sdeskills.tictactoe;

public class TicTacToeBoard {
    private char board[][];

    public TicTacToeBoard() {
        board = new char[Constants.BOARD_ROW_SIZE][Constants.BOARD_COL_SIZE];
        fillBoardWithValue(Constants.BOARD_EMPTY_VALUE);
    }

    private void fillBoardWithValue(char value) {
        for(int i = 0; i < getRowSize(); i++) {
            for(int j = 0; j < getColSize(); j++) {
                this.board[i][j] = value;
            }
        }
    }

    /**
     * @param x - row number of the board. 1-indexed
     * @param y - col number of the board. 1-indexed
     * @return - value of the board at cell(x, y)
     */
    public char getCell(int x, int y) {
        x--; y--;
        return this.board[x][y];
    }

    /**
     * @param x - row number of the board. 1-indexed
     * @param y - col number of the board. 1-indexed
     * @param value - value of the board at cell(x, y)
     */
    public void setCell(int x, int y, char value) {
        x--; y--;
        this.board[x][y] = value;
    }

    public int getRowSize() {
        return this.board.length;
    }

    public int getColSize() {
        return this.board[0].length;
    }

    public boolean isCellEmpty(int i, int j) {
        return this.board[i][j] == Constants.BOARD_EMPTY_VALUE
    }
}
