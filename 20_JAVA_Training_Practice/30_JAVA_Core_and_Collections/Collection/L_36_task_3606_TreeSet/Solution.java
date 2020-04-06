package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/*
Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортируй буквы по алфавиту и выведи на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то выведи их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрой потоки.

Пример 1 данных входного файла:
zBk yaz b-kN

Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB

Пример 2 вывода:
abc

Подсказка: использовать TreeSet

Требования:
•	Программа должна использовать класс TreeSet.
•	У объекта типа TreeSet вызови метод add для добавления элементов.
•	Программа должна выводить результат на экран.
•	Вывод программы должен соответствовать условию задачи.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> charSet = new TreeSet<>();
        try (BufferedReader rdr = new BufferedReader(new FileReader(args[0]))) {
            while (rdr.ready()) {
                String s = rdr.readLine().replaceAll("[^\\p{Alpha}]","");
                for (int i = 0; i < s.length(); i++)
                    charSet.add(s.charAt(i));
            }
        }

        Iterator<Character> iterator = charSet.iterator();
        int n = charSet.size() < 5 ? charSet.size() : 5;

        for (int i = 0; i < n; i++) {
            System.out.print((iterator.next()));
        }
    }
}