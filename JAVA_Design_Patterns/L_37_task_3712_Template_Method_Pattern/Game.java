package com.company;

public abstract class Game {
    public abstract void prepareForTheGame();

    public abstract void playGame();

    public abstract void congratulateWinner();

    public void run () {
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }

}