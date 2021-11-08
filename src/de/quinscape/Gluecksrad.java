package de.quinscape;

import java.util.*;

public class Gluecksrad {
    private Random randomGenerator = new Random();
    private String currentWord;

    public void startGame() {
        System.out.println("CITY GUESSER");
        randomWordGenerator();
        gameLoop();
    }

    public static LinkedList<String> wordList() {
        LinkedList<String> words = new LinkedList<>();
        words.add("Dortmund");
        words.add("Bochum");
        words.add("Münster");
        words.add("Düsseldorf");
        words.add("Hamburg");
        words.add("Berlin");
        return words;
    }

    public void randomWordGenerator() {
        currentWord = wordList().get(randomGenerator.nextInt(wordList().size()));
    }

    public boolean checkInputLetterAmount(String userInput){
        if(userInput.length() != 1){
            return false;
        }
        return true;
    }

    public void gameLoop() {
        boolean done = false;
        boolean[] rightCharGuessed = new boolean[currentWord.length()];
        System.out.println("You have " + getMaxTries() + " rounds to guess the right word.");

        int currentRound = 0;
        printWordToGuess(rightCharGuessed);
        while (!done) {
            String userInput = getUserInput();
            if(!checkInputLetterAmount(userInput)){
                System.out.println("Guess the city with one letter at a time: ");
                continue;
            }
            char letter = userInput.toLowerCase().charAt(0);
            updateGuessedChar(letter, rightCharGuessed);
            printWordToGuess(rightCharGuessed);

            if (isGameWon(rightCharGuessed)) {
                System.out.println("Word guessed, game is now ending...");
                done = true;
            } else if (currentRound == getMaxTries()) {
                System.out.println("Game over. No more tries left");
                done = true;
            } else {
                currentRound++;
                System.out.println("Round " + currentRound);
            }
        }
    }

    public String getUserInput(){
        Scanner charScanner = new Scanner(System.in);
        return charScanner.nextLine();
    }

    private int getMaxTries() {
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
}