package de.quinscape;

import java.util.*;

public class Gluecksrad {
    private final Random randomGenerator = new Random();
    private final Player player = new Player();

    public void startGame() {
        System.out.println("CITY GUESSER");
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
        player.setCurrentWord(wordList().get(randomGenerator.nextInt(wordList().size())));
    }

    public void gameLoop() {
        String name = player.getPlayerName();
        boolean done = false;
        boolean[] rightCharGuessed = new boolean[player.getCurrentWord().length()];
        System.out.println("Hi " + name + ". You have " + player.getMaxTries() +
                " rounds to guess the right word.");

        int currentRound = 0;
        player.printWordToGuess(rightCharGuessed);
        while (!done) {
            String userInput = player.getUserInput();
            if(!player.checkInputLetterAmount(userInput)){
                System.out.println("Guess the city with one letter at a time: ");
                continue;
            }
            char letter = userInput.toLowerCase().charAt(0);
            player.updateGuessedChar(letter, rightCharGuessed);
            player.printWordToGuess(rightCharGuessed);

            if (player.isGameWon(rightCharGuessed)) {
                System.out.println(name + " won!" + " Game is now ending...");
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