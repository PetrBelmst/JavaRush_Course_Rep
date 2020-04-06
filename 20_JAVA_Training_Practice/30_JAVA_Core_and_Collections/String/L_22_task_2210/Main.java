package com.company;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример
getTokens("level22.lesson13.task01", ".")
возвращает массив строк
{"level22", "lesson13", "task01"}
Требования:
•	Метод getTokens должен использовать StringTokenizer.
•	Метод getTokens должен быть публичным.
•	Метод getTokens должен принимать два параметра типа String.
•	Массив типа String возвращенный методом getTokens должен быть заполнен правильно(согласно условию задачи).
*/
public class Main {

    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> tokList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()) {
            tokList.add(tokenizer.nextToken());
        }
        String[] result = tokList.toArray(new String[0]);
        return result;
    }
}
