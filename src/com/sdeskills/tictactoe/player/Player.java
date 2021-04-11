package com.sdeskills.tictactoe.player;

import com.sdeskills.utils.Pair;

public abstract class Player {

    private String name;

    protected char playerSymbol;

    public String getName() {
        return name;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public void setName(String name) {
        this.name = name;
    }
}
