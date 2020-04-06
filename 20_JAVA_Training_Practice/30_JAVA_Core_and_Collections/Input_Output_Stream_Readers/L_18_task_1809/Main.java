package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.
Требования:
•	Программа должна два раза считать имена файлов с консоли.
•	Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
•	Во второй файл нужно записать все байты из первого в обратном порядке.
•	Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rdr.readLine();
        String file2 = rdr.readLine();
        rdr.close();

        FileInputStream fIS = new FileInputStream(file1);
        FileOutputStream fOS = new FileOutputStream(file2);
        ArrayList<Integer> list = new ArrayList<>();

        while (fIS.available() > 0) {
            int temp = fIS.read();
            list.add(temp);
        }
        fIS.close();
        Collections.reverse(list);
        for (int t : list) {
            fOS.write(t);
        }
        fOS.close();
    }
}
