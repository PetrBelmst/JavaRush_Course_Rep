package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        //напишите тут ваш код
        char [] lineToChar = line.toCharArray();
        for (int i = 0; i < lineToChar.length; i++) {
            if (i == 0 || lineToChar [i-1] == ' ' && i < lineToChar.length - 1)
                lineToChar[i] = Character.toUpperCase(lineToChar[i]);
        }
        System.out.println(lineToChar);
    }
}

