package de.quinscape;

import java.util.Scanner;

public class Player { //nur setter und getter, nur eigenschaften enthalten //alles raushauen was ne aktion macht , nur daten drin stehen
    private String playerName;
    private final Scanner sc = new Scanner (System.in);
    private String currentWord;

    public String getUserInput(){
        Scanner charScanner = new Scanner(System.in);
        return charScanner.nextLine();
    }

    public int getMaxTries() {
        return currentWord.length() * 2;
    }

    public void updateGuessedChar(char letter, boolean[] rightCharGuessed) {
        for (int i = 0; i < rightCharGuessed.length; i++) {
            if (currentWord.toLowerCase().charAt(i) == letter) {
                rightCharGuessed[i] = true;
            }
        }
    }

    public boolean isGameWon(boolean[] rightCharGuessed){
        for(int i = 0; i < rightCharGuessed.length ; i++){
            boolean done = rightCharGuessed[i];
            if (!done) {
                return false;
            }
        }
        return true;
    }

    public void setPlayerName() {
        this.playerName = sc.nextLine();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public String getCurrentWord() {
        return currentWord;
    }
}