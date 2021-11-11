package de.quinscape;

import java.util.*;

public class Gluecksrad {
    private final Random randomGenerator = new Random();
    private Player player;

    public void startGame() {
        System.out.println("CITY GUESSER");
        createPlayer();
        randomWordGenerator();
        gameLoop();
    }

    public void createPlayer() {
        System.out.print("Enter your name: ");
        String playerName = getUserInput();
        player = new Player(playerName);
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

    public void printWordToGuess() {
        System.out.println("Guess the city with one letter at a time: ");
        for (int i = 0; i < player.getCurrentWord().length(); i++) {
            if (!player.getRightCharGuessed()[i]) {
                System.out.print("_");
            } else {
                System.out.print(player.getCurrentWord().charAt(i));
            }
        }
        System.out.println("\n");
    }

    public String getUserInput() {
        Scanner charScanner = new Scanner(System.in);
        return charScanner.nextLine();
    }

    public int getMaxTries() {
        return player.getCurrentWord().length() * 2;
    }

    public boolean checkInputLetterAmount(String userInput) {
        return userInput.length() == 1;
    }

    public void updateGuessedChar(char letter) {
        for (int i = 0; i < player.getRightCharGuessed().length; i++) {
            if (player.getCurrentWord().toLowerCase().charAt(i) == letter) {
                player.getRightCharGuessed()[i] = true;
            }
        }
    }

    public boolean isGameWon() {
        for (int i = 0; i < player.getRightCharGuessed().length; i++) {
            boolean done = player.getRightCharGuessed()[i];
            if (!done) {
                return false;
            }
        }
        return true;
    }

    public void gameLoop() {
        boolean isGameOver = false;

        System.out.println("Hi " + player.getPlayerName() + ". You have " + getMaxTries() +
                " rounds to guess the right word.");
        int currentRound = 0;
        printWordToGuess();
        while (!isGameOver) {
            String userInput = getUserInput();
            if (Objects.equals(userInput, player.getCurrentWord())) {
                isGameOver = true;
                System.out.println("You win!!!");
            } else if (!checkInputLetterAmount(userInput)) {
                System.out.println("Guess the city with one letter at a time: ");
            } else {
                char letter = userInput.toLowerCase().charAt(0);
                updateGuessedChar(letter);
                printWordToGuess();

                if (isGameWon()) {
                    System.out.println("You win! Game is now ending...");
                    isGameOver = true;
                } else if (currentRound == getMaxTries()) {
                    System.out.println("Game over. No more tries left");
                    isGameOver = true;
                } else {
                    currentRound++;
                    System.out.println("Round " + currentRound);
                }
            }
        }
    }
}