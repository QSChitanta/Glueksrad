package de.quinscape;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Gluecksrad {
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

    public void random() {
        Random randomGenerator = new Random();
        String randomCity = cityList().get(randomGenerator.nextInt(cityList().size()));
        System.out.println(randomCity);

        if(randomCity != userInput()){
          triesLeft(6);
          userInput();
        }

    }

    public void triesLeft(int number){
      for(int i = number; i > 0; i--){
        System.out.println("You have " + i + " tries left");
      }
    }

    public String userInput(){
      Scanner input = new Scanner(System.in);
      for(int i = 6; i > 0; i--){
          System.out.println("Enter city name (" + i + " tries left)");
//          if(input.nextLine()==){
//              input.nextLine();
//          }

      }
      return input.nextLine();
    }

}
