package com.company;
/*
Гласные и согласные
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы из введённой строки.
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
Требования:
•	Программа должна считывать данные с клавиатуры.
•	Программа должна выводить две строки.
•	Первая строка должна содержать только гласные буквы из введенной строки, разделенные пробелом.
•	Вторая строка должна содержать только согласные и знаки препинания из введенной строки, разделенные пробелом.
•	Каждая строка должна заканчиваться пробелом.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {

        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String inputText = null;
        ArrayList<Character> glas = new ArrayList();
        ArrayList<Character> soglas = new ArrayList();

        inputText = rdr.readLine().replace(" ", "");

        for (Character temp : inputText.toCharArray()) {
                if (isVowel(temp)) {
                    glas.add(temp);
                    glas.add(' ');
                } else {
                    soglas.add(temp);
                    soglas.add(' ');
                }
        }

        for (int i = 0; i < glas.size(); i++) {
            System.out.print(glas.get(i));
        }
        System.out.println();

        for (int i = 0; i < soglas.size(); i++) {
            System.out.print(soglas.get(i));
        }
        System.out.println();
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}