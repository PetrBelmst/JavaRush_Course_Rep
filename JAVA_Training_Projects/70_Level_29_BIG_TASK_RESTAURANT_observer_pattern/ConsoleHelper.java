package com.company;

import com.company.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);

    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> chosenDishes = new ArrayList<>();
        writeMessage("please choose dish(es), to finish input exit");
        writeMessage(Dish.allDishesToString());
        while (true) {
            String orderedDish = readString();
            if (orderedDish.equalsIgnoreCase("exit")) {
                break;
            }
            if (orderedDish.isEmpty()) {
                writeMessage("dish was not chosen");
                continue;
            }
            boolean match = false;
            for (Dish element : Dish.values()) {
                if (element.name().equalsIgnoreCase(orderedDish)) {
                    chosenDishes.add(element);
                    match = true;
                }
            }
            if (!match) {
                writeMessage("dish does not available");
            }
        }
        return chosenDishes;
    }
}
