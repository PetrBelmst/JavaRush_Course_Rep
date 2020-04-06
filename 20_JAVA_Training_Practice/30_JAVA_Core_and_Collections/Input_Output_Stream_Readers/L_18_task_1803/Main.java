package com.company;
/*
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.

Требования:
•	Программа должна считывать имя файла с консоли.
•	Для чтения из файла используй поток FileInputStream.
•	В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
•	Данные в консоль должны выводится в одну строку.
•	Поток чтения из файла должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fIS = new FileInputStream(rdr.readLine());
        rdr.close();
        int [] mas = new int[256];
        while (fIS.available() > 0) {
            mas[fIS.read()]++;

        }
        fIS.close();
        int repeat = 0;
        for (int i = 0; i <mas.length; i++) {
            if (repeat < mas[i]) {repeat = mas[i];}
        }
        for (int i = 0; i < mas.length; i++) {
            if (repeat == mas[i]) {
                System.out.println(i + " ");
            }
        }
    }
}

