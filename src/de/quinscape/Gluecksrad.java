package de.quinscape;

import java.util.*;

public class Gluecksrad {
    private Random randomGenerator = new Random();
    private String currentWord;

    public void startGame() {
        System.out.println("CITY GUESSER");
        randomWordGenerator();
        userInput();
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

    public void userInput() {
        Scanner input = new Scanner(System.in);
        gameEngine(input);
    }

    public boolean checkInputLetterAmount(String userInput){
        if(userInput.length() != 1){
            return false;
        }
        return true;
    }

    public void gameEngine(Scanner input) {
        boolean done = false;
        getMaxTries();
        boolean[] rightCharGuessed = new boolean[currentWord.length()];
        System.out.println("You have " + getMaxTries() + " rounds to guess the right word.");

        int currentRound = 0;
        wordOrLinePrinter(rightCharGuessed);
        while (!done) {
            String userInput = input.nextLine();
            char letter = userInput.toLowerCase().charAt(0);

            if(!checkInputLetterAmount(userInput)){
                System.out.println("Guess the city with one letter at a time: ");
                continue;
            }

            updateGuessedChar(letter, rightCharGuessed);
            wordOrLinePrinter(rightCharGuessed);

            if (currentRound == getMaxTries()) {
                input.close();
                System.out.println("Game over. No more tries left");
                done = true;
            } else if (isGameWon(rightCharGuessed)) {
                System.out.println("Word guessed, game is now ending...");
                input.close();
                done = true;
            } else {
                currentRound++;
                System.out.println("Round " + currentRound);
            }
        }
    }

    private int getMaxTries() {
        int maxTries = currentWord.length() * 2;
        return maxTries;
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

    public void wordOrLinePrinter(boolean[] rightCharGuessed) {
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