package com.company;
/*
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.
Пример тела файла:
12 text var2 14 8ю 1
Результат:
12 14 1
Требования:
•	Программа должна считывать имена файлов с консоли (используй BufferedReader).
•	BufferedReader для считывания данных с консоли должен быть закрыт.
•	Программа должна считывать содержимое первого файла (используй BufferedReader c
конструктором принимающим FileReader).
•	Поток чтения из файла (BufferedReader) должен быть закрыт.
•	Программа должна записывать во второй файл все числа, через пробел, из первого файла
(используй BufferedWriter с конструктором FileWriter).
•	Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rdr.readLine();
        String file2 = rdr.readLine();
        rdr.close();
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        StringBuilder stringBuilder = new StringBuilder();
        while (reader.ready()) {
            stringBuilder.append((char) reader.read());
        }
        Pattern p = Pattern.compile("(\\b|^)\\d+?(\\b|$)");
        Matcher matcher = p.matcher(stringBuilder);
        while (matcher.find()) {
            writer.write(stringBuilder.substring(matcher.start(), matcher.end()) + " ");
        }
        reader.close();
        writer.close();
    }
}
