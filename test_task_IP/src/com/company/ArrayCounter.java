package com.company;

import java.io.*;
import java.util.Date;

//метод этого класса является решением тестового задания
public class ArrayCounter {

    public static Long uniqueIPCounter(File inputFile) {
        boolean[][][][] checkingArray = new boolean[256][256][256][256];
        long count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String fileLine;

            while ((fileLine = reader.readLine()) != null) {

                String[] splitOfIP = fileLine.trim().split("\\.");

                short zero = Short.parseShort(splitOfIP[0]);
                short first = Short.parseShort(splitOfIP[1]);
                short second = Short.parseShort(splitOfIP[2]);
                short third = Short.parseShort(splitOfIP[3]);

                if (!checkingArray[zero][first][second][third]) {
                    checkingArray[zero][first][second][third] = true;
                    count++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
