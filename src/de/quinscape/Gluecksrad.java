package de.quinscape;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;


public class Gluecksrad {
    Scanner input = new Scanner(System.in);

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
    }


}
