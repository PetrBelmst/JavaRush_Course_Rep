package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Минимальный байт
Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.
Требования:
•	Программа должна считывать имя файла с консоли.
•	Для чтения из файла используй поток FileInputStream.
•	В консоль должен выводиться минимальный байт, считанный из файла.
•	Поток чтения из файла должен быть закрыт.
*/
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fIS = new FileInputStream(rdr.readLine());
        rdr.close();
        int temp = fIS.read();
        int min= temp;
        while (fIS.available() > 0 ) {
            temp = fIS.read();
            if (min > temp) {
                min = temp;
            }
        }
        fIS.close();
        System.out.println(min);

    }
}
