package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap(10);
        map.put("A", 1);
        map.put("s", 1);
        map.put("d", 1);
        map.put("f", 600);
        map.put("g", 900);
        map.put("h", 1);
        map.put("j", 500);
        map.put("k", 1);
        map.put("l", 1);
        map.put("z", 700);

        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {

        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String,Integer> pair = iterator.next();
            if (pair.getValue()<500) {
                iterator.remove();
            }
        }
    }


    public static void main(String[] args) {
        Map<String, Integer> map=createMap();
        System.out.println(map);
        removeItemFromMap(map);
        System.out.println(map);
    }
}
