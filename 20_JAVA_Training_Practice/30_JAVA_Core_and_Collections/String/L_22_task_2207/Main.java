package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/*
Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.
Кодировка файла - UTF-8.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
Требования:
•	Метод main должен считывать имя файла с клавиатуры.
•	В методе main должен быть использован StringBuilder.
•	В классе Solution должен содержаться вложенный класс Pair с методами equals, hashCode и toString.
Удалять или изменять эти методы нельзя.
•	В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
•	Список result должен быть заполнен корректными парами согласно условию задачи.
*/
public class Main {

    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fIS = new FileInputStream(rdr.readLine());
        rdr.close();

        BufferedReader rdrFile = new BufferedReader(new InputStreamReader(fIS));
        StringBuilder fileToString = new StringBuilder();
        while (rdrFile.ready()) {
            fileToString.append(rdrFile.readLine().trim() + " ");
        }
        rdrFile.close();
        fIS.close();

        String[] fileToStringArr = fileToString.toString().trim().split("\\s");
        StringBuilder fTS1;
        for (int i = 0; i < fileToStringArr.length - 1; i++) {
            for (int j = i + 1; j < fileToStringArr.length; j++) {
                fTS1 = new StringBuilder(fileToStringArr[i]);
                if (fTS1.reverse().toString().equals(fileToStringArr[j])) {
                    Pair pair = new Pair();
                    pair.first = fTS1.reverse().toString();
                    pair.second = fileToStringArr[j];
                    if (!result.contains(pair)) {
                        result.add(pair);
                    }
                }
            }

        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
}

