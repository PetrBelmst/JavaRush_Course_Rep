package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        Map <Integer, String> callend = new HashMap(12);
        callend.put(1,"January");
        callend.put(2,"February");
        callend.put(3,"March");
        callend.put(4,"April");
        callend.put(5,"May");
        callend.put(6,"June");
        callend.put(7,"July");
        callend.put(8,"August");
        callend.put(9,"September");
        callend.put(10,"October");
        callend.put(11,"November");
        callend.put(12,"December");

        BufferedReader rdr828 = new BufferedReader(new InputStreamReader(System.in));
        String inputMonth = rdr828.readLine();

        Iterator<Map.Entry<Integer, String>> iterator = callend.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<Integer,String> pair = iterator.next();
            Integer temp1 = pair.getKey();
            String temp2 = pair.getValue();

            if (inputMonth.equals(temp2)) {
                System.out.println(temp2 + " is the " + temp1 + " month");
            }
        }
    }
}











