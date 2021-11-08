package de.quinscape;

import java.util.Scanner;

public class Player {
    private String playerName;
    private Scanner sc = new Scanner (System.in);

    public void setPlayerName() {
        this.playerName = sc.nextLine();
    }
}
