package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/*
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.
Требования:
•	Программа должна два раза считать имена файлов с консоли.
•	Не используй в программе статические переменные.
•	Для первого файла создай поток для чтения и считай его содержимое.
•	Затем, для первого файла создай поток для записи(поток для записи должен быть один).
Для второго - для чтения.
•	Содержимое первого и второго файла нужно объединить в первом файле.
•	Сначала должно идти содержимое второго файла, затем содержимое первого.
•	Созданные для файлов потоки должны быть закрыты.
*/
public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String file1, file2;
        file1 = rdr.readLine();
        file2 = rdr.readLine();
        rdr.close();

        FileInputStream fISForFile1 = new FileInputStream(file1);
        byte[] arrayForFile1 = new byte[fISForFile1.available()];
        fISForFile1.read(arrayForFile1);
        fISForFile1.close();

        FileInputStream fISForFile2 = new FileInputStream(file2);
        byte[] arrayForFile2 = new byte[fISForFile2.available()];
        fISForFile2.read(arrayForFile2);
        fISForFile2.close();

        FileOutputStream fOS = new FileOutputStream(file1);
        fOS.write(arrayForFile2);
        fOS.write(arrayForFile1);
        fOS.close();
    }
}
