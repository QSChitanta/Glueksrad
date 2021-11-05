package de.quinscape;

import java.util.*;

public class Gluecksrad {
    private Random randomGenerator = new Random();
    private String currentCity;

    public void startGame() {
        System.out.println("CITY GUESSER");
        loadCurrentCity();
        userInput();
    }

    public static LinkedList<String> cityList() {
        LinkedList<String> cities = new LinkedList<>();
        cities.add("Dortmund");
        cities.add("Bochum");
        cities.add("Münster");
        cities.add("Düsseldorf");
        cities.add("Hamburg");
        cities.add("Berlin");
        return cities;
    }

    public String randomCityGenerator() {
        return cityList().get(randomGenerator.nextInt(cityList().size()));
    }

    public void loadCurrentCity() {
        String randomCity = randomCityGenerator();
        setCurrentCity(randomCity);
    }

    public void userInput() {
        Scanner input = new Scanner(System.in);
        roundCounter(input);
    }

    public void roundCounter(Scanner input) {
        boolean done = false;
        int maxTries = currentCity.length() * 2;
        boolean[] rightCharGuessed = new boolean[currentCity.length()];
        System.out.println("You have " + maxTries + " rounds to guess the right word.");

        int currentRound = 0;
        wordOrLinePrinter(rightCharGuessed);
        while (!done) {
            String userInput = input.nextLine();
            char letter = userInput.toLowerCase().charAt(0);

            checkInput(letter, rightCharGuessed);
            wordOrLinePrinter(rightCharGuessed);

            if (currentRound == maxTries) {                             //austauschen: if und else if umdrehen
                input.close();
                System.out.println("Game over. No more tries left");
                done = true;
            } else if (charGuessing(rightCharGuessed)) {
                System.out.println("Word guessed, game is now ending...");
                input.close();
                done = true;
            } else {
                currentRound++;
                System.out.println("Round " + currentRound);
            }
        }
    }

    public void checkInput(char letter, boolean[] rightCharGuessed) {
        for (int i = 0; i < rightCharGuessed.length; i++) {
            if (currentCity.toLowerCase().charAt(i) == letter) {
                rightCharGuessed[i] = true;
            }
        }
    }

    public boolean charGuessing(boolean[] rightCharGuessed) {
        for (boolean i : rightCharGuessed) {
            if (!i) {
                return false;
            }
        }
        return true;
    }

    public void wordOrLinePrinter(boolean[] rightCharGuessed) {
        System.out.println("Guess the city with one letter at a time: ");
        for (int i = 0; i < currentCity.length(); i++) {
            if (!rightCharGuessed[i]) {
                System.out.print("_");
            } else {
                System.out.print(currentCity.charAt(i));
            }
        }
        System.out.println("\n");
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }
}