package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                String id = reader.readLine();
                if (id.isEmpty()) {
                    break;
                }
                String name = reader.readLine();

                if (name.isEmpty()) {
                    map.put("", id);
                    break;
                }
                map.put(name, id);
            }
        } catch (NullPointerException e) {}

        for (Map.Entry<String, String> pair : map.entrySet()) {
            String id = pair.getKey();
            String Name = pair.getValue();
            System.out.println(Name + " " + id);
        }
    }
}

