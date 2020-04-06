package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.

Требования:
•	Программа должна считывать имя файла с консоли (используй BufferedReader).
•	BufferedReader для считывания данных с консоли должен быть закрыт.
•	Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
•	Поток чтения из файла (FileReader) должен быть закрыт.
•	Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/
public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rdr.readLine();
        FileReader reader = new FileReader(fileName);
        rdr.close();
        String s = "";
        int count = 0;
        while (reader.ready()) {
            int a = reader.read();
            if (a >= 97 && a <= 122) {
                s = s + (char) a;
            } else {
                if (s.equals("world"))
                    count++;
                s = "";
            }
        }
        reader.close();
        System.out.println(count);
    }
}