package com.sdeskills.tictactoe.player;

import com.sdeskills.utils.Pair;

public abstract class Player {

    private String name;

    public abstract Pair<Integer, Integer> nextMove();

    public String getName() {
     }

    public void setName(String name) {
        this.name = name;
    }
}
