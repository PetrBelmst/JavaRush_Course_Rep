package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();

        while (true) {
            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }
            list.add(family);
        }

        // Read the house number
        String cityName = reader.readLine();

        for (int i = 0; i<list.size(); i++) {
            if (list.get(i).equals(cityName)) {
                System.out.println(list.get(i+1));
            }
        }
    }
}
