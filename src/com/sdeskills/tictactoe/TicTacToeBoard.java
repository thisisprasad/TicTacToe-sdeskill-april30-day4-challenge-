package com.sdeskills.tictactoe;

public class TicTacToeBoard {
    private char board[][];

    public TicTacToeBoard() {
        board = new char[Constants.BOARD_ROW_SIZE][Constants.BOARD_COL_SIZE];
        fillBoardWithValue(Constants.BOARD_EMPTY_VALUE);
    }

    private void fillBoardWithValue(char value) {
        for (int i = 0; i < getRowSize(); i++) {
            for (int j = 0; j < getColSize(); j++) {
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
        x--;
        y--;
        return this.board[x][y];
    }

    /**
     * @param x     - row number of the board. 1-indexed
     * @param y     - col number of the board. 1-indexed
     * @param value - value of the board at cell(x, y)
     */
    public void setCell(int x, int y, char value) {
        x--;
        y--;
        this.board[x][y] = value;
    }

    public int getRowSize() {
        return this.board.length;
    }

    public int getColSize() {
        return this.board[0].length;
    }

    public boolean isCellEmpty(int i, int j) {
        return this.board[i][j] == Constants.BOARD_EMPTY_VALUE;
    }

    /**
     * Checks whether any player has won game till now.
     * Assumes that tic-tac-toe board is of size 3x3 only.
     *
     * @param playerValue
     * @return
     */
    public boolean hasWonGame(char playerValue) {
        for (int row = 0; row < this.getRowSize(); row++) {
            if (this.board[row][0] == playerValue &&
                    this.board[row][0] == this.board[row][1] && this.board[row][1] == this.board[0][2]) {
                return true;
            }
        }
        for (int col = 0; col < this.getColSize(); col++) {
            if (this.board[0][col] == playerValue &&
                    this.board[0][col] == this.board[1][col] && this.board[1][col] == this.board[2][col]) {
                return true;
            }
        }
        if (this.board[0][0] == playerValue &&
                this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2]) {
            return true;
        }
        if (this.board[0][2] == playerValue &&
                this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0]) {
            return true;
        }

        return false;
    }

    /**
     * Checks whether can any move be made on the board by a player.
     * @return
     */
    public boolean hasMovesLeft() {
        for(int i = 0; i < this.getRowSize(); i++) {
            for(int j = 0; j < this.getColSize(); j++) {
                if(this.board[i][j] == Constants.BOARD_EMPTY_VALUE)
                    return true;
            }
        }
        return false;
    }
}
