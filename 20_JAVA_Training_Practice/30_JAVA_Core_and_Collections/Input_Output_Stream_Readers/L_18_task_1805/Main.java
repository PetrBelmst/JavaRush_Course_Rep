package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/*
Сортировка байт
Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.
Пример байт входного файла:
44 83 44
Пример вывода:
44 83
Требования:
•	Программа должна считывать имя файла с консоли.
•	Для чтения из файла используй поток FileInputStream.
•	В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
•	Данные в консоль должны выводится в одну строку.
•	Поток чтения из файла должен быть закрыт.
*/
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fIS = new FileInputStream(rdr.readLine());
        rdr.close();
        TreeSet<Integer> set = new TreeSet<>();
        while (fIS.available() > 0) {
            set.add(fIS.read());
        } fIS.close();

        for (Integer i : set) {
            System.out.print(i + " ");
        }
    }
}
