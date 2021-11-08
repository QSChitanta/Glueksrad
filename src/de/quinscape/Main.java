package de.quinscape;

public class Main {
    public static void main(String[] args) {
        Gluecksrad gr = new Gluecksrad();
        Player player = new Player();
        player.setPlayerName();
        gr.startGame();
    }
}
