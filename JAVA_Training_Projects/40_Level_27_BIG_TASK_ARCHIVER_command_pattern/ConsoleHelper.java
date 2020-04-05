package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String readStringFromConsole = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readStringFromConsole = reader.readLine();
        return readStringFromConsole;
    }

    public static int readInt() throws IOException {
        return Integer.parseInt(readString());
    }
}