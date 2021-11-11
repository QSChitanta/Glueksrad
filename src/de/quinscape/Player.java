package de.quinscape;

public class Player {
    private final String playerName;
    private String currentWord;
    private boolean[] rightCharGuessed;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
        this.rightCharGuessed = new boolean[getCurrentWord().length()];
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public boolean[] getRightCharGuessed() {
        return rightCharGuessed;
    }
}