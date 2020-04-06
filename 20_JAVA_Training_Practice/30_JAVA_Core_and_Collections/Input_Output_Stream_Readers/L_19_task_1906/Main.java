package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

/*
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).
Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод
Требования:
•	Программа должна считывать имена файлов с консоли (используй BufferedReader).
•	BufferedReader для считывания данных с консоли должен быть закрыт.
•	Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
•	Поток чтения из файла (FileReader) должен быть закрыт.
•	Программа должна записывать во второй файл все байты из первого файла с четным порядковым
номером (используй FileWriter).
•	Поток записи в файл (FileWriter) должен быть закрыт.
*/
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rdr.readLine();
        String file2 = rdr.readLine();
        rdr.close();

        FileReader reader = new FileReader(file1);
        FileWriter writer = new FileWriter(file2);

        while (reader.ready()) {
            int q = reader.read();
            int w = reader.read();
            writer.write(w);
        }
        reader.close();
        writer.close();
    }
}
