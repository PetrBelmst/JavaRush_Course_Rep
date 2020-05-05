package com.company;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

//метод этого класса использован для сравнения производительности
public class SetCounter {

    public static Long setCount(File inputFile) {
        Set<String> set = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String fileLine;
            while ((fileLine = reader.readLine()) != null) {
                set.add(fileLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Long.valueOf(set.size());
    }
}
