package de.quinscape;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gluecksrad {
    public String retrieveUserInput(){
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }

    public void pickRandomWord (List<String> words){

    }

    public void wordArray(){
        String[] cityArray = {"hamburg", "dortmund", "berlin", "düsseldorf", "münchen", "münster"};
    }

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

}
