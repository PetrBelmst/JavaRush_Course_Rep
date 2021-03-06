package com.company;
/*
Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.
Результат вывести во второй файл.
Закрыть потоки.
Требования:
•	Программа должна считывать имена файлов с консоли (используй BufferedReader).
•	BufferedReader для считывания данных с консоли должен быть закрыт.
•	Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
•	Поток чтения из файла (BufferedReader) должен быть закрыт.
•	Программа должна записывать во второй файл содержимое первого файла, где удалены все знаки пунктуации,
включая символы новой строки (Для записи в файл используй BufferedWriter с конструктором FileWriter).
•	Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rdr.readLine();
        String file2 = rdr.readLine();
        rdr.close();
        BufferedReader reader = new BufferedReader (new FileReader(file1));
        BufferedWriter writer = new BufferedWriter (new FileWriter(file2));
        writer.write(reader.readLine().replaceAll("[^\\w\\s]", ""));
        reader.close();
        writer.close();
    }
}