package de.quinscape;

import java.util.*;

public class Gluecksrad {
    private final Random randomGenerator = new Random();
    private final Player player = new Player();

    public void startGame() {
        System.out.println("CITY GUESSER");
        System.out.println("Enter your name: ");
        player.setPlayerName();
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
        int randomIndex = randomGenerator.nextInt(wordList().size());
        player.setCurrentWord(wordList().get(randomIndex));
    }

    public boolean checkInputLetterAmount(String userInput){
        if(userInput.length() != 1){
            return false;
        }
        return true;
    }

    public void printWordToGuess(boolean[] rightCharGuessed) {
        System.out.println("Guess the city with one letter at a time: ");
        for (int i = 0; i < player.getCurrentWord().length(); i++) {
            if (!rightCharGuessed[i]) {
                System.out.print("_");
            } else {
                System.out.print(player.getCurrentWord().charAt(i));
            }
        }
        System.out.println("\n");
    }

    public void gameLoop() {
        boolean done = false;
        boolean[] rightCharGuessed = new boolean[player.getCurrentWord().length()];
        System.out.println("Hi " + player.getPlayerName() + ". You have " + player.getMaxTries() +
                " rounds to guess the right word.");

        int currentRound = 0;
        printWordToGuess(rightCharGuessed);
        while (!done) {
            String userInput = player.getUserInput();
            if(!checkInputLetterAmount(userInput)){
                System.out.println("Guess the city with one letter at a time: ");
                continue;
            }
            char letter = userInput.toLowerCase().charAt(0);
            player.updateGuessedChar(letter, rightCharGuessed);
            printWordToGuess(rightCharGuessed);

            if (player.isGameWon(rightCharGuessed)) {
                System.out.println(player.getPlayerName() + " won!" + " Game is now ending...");
                done = true;
            } else if (currentRound == player.getMaxTries()) {
                System.out.println("Game over. No more tries left");
                done = true;
            } else {
                currentRound++;
                System.out.println("Round " + currentRound);
            }
        }
    }
}