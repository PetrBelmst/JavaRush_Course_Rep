package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.

Требования:
•	Программа должна считывать имя файла с консоли.
•	Для чтения из файла используй поток FileInputStream.
•	В консоль должен выводиться максимальный байт, считанный из файла.
•	Поток чтения из файла должен быть закрыт.
*/
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fIS = new FileInputStream(rdr.readLine());
        rdr.close();
        int max = 0;
        while (fIS.available() > 0) {
            int temp = fIS.read();
            if (temp > max) {
                max = temp;
            }
        } fIS.close();
        System.out.println(max);
    }
}
