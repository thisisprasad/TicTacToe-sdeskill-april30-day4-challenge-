package com.sdeskills.tictactoe;

public class TicTacToeBoard {
    private char board[][];

    public TicTacToeBoard() {
        board = new char[Constants.BOARD_ROW_SIZE][Constants.BOARD_COL_SIZE];
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
}
