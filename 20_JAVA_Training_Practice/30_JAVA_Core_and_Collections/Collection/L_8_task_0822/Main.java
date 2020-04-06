package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int b = Collections.min(array);
        return b;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader rdr822 = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(rdr822.readLine());
        List<Integer> array1 = new ArrayList<Integer>(a);

        for (int i = 0; i<a; i++) {
            array1.add(Integer.parseInt(rdr822.readLine()));
        }
        return array1;
    }
}