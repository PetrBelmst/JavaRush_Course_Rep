package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        System.out.println(map);
        removeTheFirstNameDuplicates(map);
        System.out.println(map);
    }

    public static Map<String, String> createMap() {

        Map<String, String> map = new HashMap<>(10);

        map.put("A", "B");
        map.put("f", "t");
        map.put("v", "w");
        map.put("e", "z");
        map.put("r", "x");
        map.put("t", "B");
        map.put("y", "B");
        map.put("u", "B");
        map.put("o", "B");
        map.put("p", "B");

        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {

        Map<String, String> copy1 = new HashMap<>(map);
        int flag = 0;
        for (Map.Entry<String, String> pair : copy1.entrySet()) {
            for (Map.Entry<String, String> pair1 : copy1.entrySet()) {
                if (pair.getValue().equals(pair1.getValue())) {
                    flag++;
                }
            }
            if (flag > 1) {
                removeItemFromMapByValue(map, pair.getValue());
                flag = 0;
            }
        }
    }


    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }
}
