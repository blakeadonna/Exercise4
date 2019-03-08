package com.blakey.exercise4;
import java.util.*;

//Johnny Nguyen | Exercise 4

public class Main {
    static void displayCities(Map<String, List<Double>> cities) {
        for (String key : cities.keySet()) {
            List<Double> temps = cities.get(key);
            Double total = 0.0;
            for (int b = 0; b < temps.size(); b++) {
                total = total + temps.get(b);
            }
            total = total / temps.size();
            System.out.println("City: " + key
                    + " " + "Average: " + total);
        }
    }

    static Map<String, List<Double>> assignTemperatures(List<String> cityNames,
                                                        List<Double> temps) {
        Map<String, List<Double>> temperatures = new TreeMap<>();


        for (int i = 0; i < cityNames.size(); i++) {
            List<Double> t = new ArrayList<>();
            for (int b = i * 5; b < ((i * 5) + 5); b++) {
                t.add(temps.get(b));
            }
            temperatures.put(cityNames.get(i), t);
        }
        return temperatures;
    }


    public static void main(String[] args) {

        Scanner avg = new Scanner(System.in);
        String cityInput = "";
        Scanner input = new Scanner(System.in);

        List<String> cityNames = new ArrayList<>();
        List<Double> temps = new ArrayList<>();

        while (!(cityInput.equals("Done"))) {

            System.out.println("Please enter a city (or cities). Enter 'Done' to move on.");
            cityInput = input.nextLine();
            if (cityInput.equals("Done")) {
                break;
            }

            cityNames.add(cityInput);
        }

        for (int b = 0; b < cityNames.size(); b++) {


            for (int i = 0; i < 5; i++) {
                System.out.println("Please enter a temperature. You will enter 5 temperatures for each city in the order of your input.");
                Double temp = avg.nextDouble();
                temps.add(temp);
            }
        }

        Map<String, List<Double>> temperatures = assignTemperatures(cityNames, temps);

        displayCities(temperatures);
    }
}
