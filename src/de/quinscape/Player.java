package de.quinscape;

import java.util.Scanner;

public class Player {
    private String playerName;
    private final Scanner sc = new Scanner (System.in);
    private String currentWord;

    public boolean checkInputLetterAmount(String userInput){
        if(userInput.length() != 1){
            return false;
        }
        return true;
    }

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

    public void printWordToGuess(boolean[] rightCharGuessed) {
        System.out.println("Guess the city with one letter at a time: ");
        for (int i = 0; i < currentWord.length(); i++) {
            if (!rightCharGuessed[i]) {
                System.out.print("_");
            } else {
                System.out.print(currentWord.charAt(i));
            }
        }
        System.out.println("\n");
    }

    public void setPlayerName() {
        System.out.println("Enter your name: ");
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