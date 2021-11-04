package de.quinscape;

import java.lang.reflect.Array;
import java.util.*;

public class Gluecksrad {
    private Random randomGenerator = new Random();

    private String currentCity;
    //private boolean foundChar;
    //private int currentAttempt -- hinzufügen wenn es soweit ist

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

    public void createRandomCity() {
        setCurrentCity(randomCityGenerator());
    }

    public void userInput() {
        Scanner input = new Scanner(System.in);
        roundCounter(input);
    }

    public void roundCounter(Scanner input) {
        boolean done = false;
        int triesLeft = getCurrentCity().length() * 2;
        System.out.println("You have " + triesLeft + " rounds to guess the right word.");

        int round = 0;
        while (!done) {
            round++;
            System.out.println("Round " + round);
            String line = input.nextLine();
            char letter = line.charAt(0);
            System.out.println(getCurrentCity().indexOf(letter));

            if (round == triesLeft) {
                input.close();
                System.out.println("Game over. No more tries left");
                done = true;
                //           } else if(wordGuessed){
//
//
//                done = true;
//                System.out.println("You win!");
//            }
            }
        }
    }
    //      TODO isGameOver Methode

    public void printCurrentCity() {
        System.out.println("Current city is: " + getCurrentCity());
    }

//          TODO: Liste erstellen um die richtig geratenen Buchstaben zu speichern
//          TODO: emptyLineWord updaten wenn buchstabe erraten wird


//    public String wordWithPlaceholder(String currentWord, List<String> gussedCharacters){
//        //TODO: die funktion solld as currentWordd ausgeben, nur mit den buchstaben die richtig geraten sind
//        //TODO: Stringbuilder baut strings (stringbuilder.apend) return
//
//    }


    public char[] cityStringToCharArray() {

        String currentCity = getCurrentCity();
        int stringLength = currentCity.length();
        char[] charArray = new char[stringLength];

        for (int i = 0; i < stringLength; i++) {
            if(currentCity.contains(charArray[i]){ //wenn currentCity "Berlin" das element i vom charArray hat --> dann
                charArray[i] = currentCity.charAt(i); // ersetze hier die entsprechende "_____" stelle mit dem char element (char toString oder so?)
            }

            //System.out.println("test: " + charArray[i]);

        }
        return charArray;
    }

//    public void foundChar(char[] cityChar) {
//        if (cityChar.contains(foundChar)) {
//
//        }
//    }

    public int letterCount() {
        int count = 0;
        for (int i = count; i < randomCityGenerator().length(); i++) {
            count++;
        }
        return count;
        //wie verbinde ich zeile 39, die anzahl der arrays elemente mit dieser methode
    }

    public int triesLeft() {
        int triesLeft = letterCount() * 2;
        return triesLeft;
    }

    public void emptyWordLine() { // _o_____
        System.out.println("Guess the city with one letter at a time: ");
        for (int i = 0; i < getCurrentCity().length(); i++) {
            System.out.print("_");
        }
        System.out.println("\n");


        //for(int i = 0; i < city.length; i++){
        //    city[i] =
        //}
        //TODO: shortcuts selber zuweisen
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public void startGame() {
        System.out.println("CITY GUESSER");
        createRandomCity();
        printCurrentCity();
        //gr.cityStringToCharArray();
        emptyWordLine();
        userInput();
    }


}
