package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Статики-2
1. В статическом блоке считайте две переменные с консоли А и В с типом int.
2. Не забыть про IOException, который надо обработать в блоке catch.
3. Закрыть поток ввода методом close().
Требования:
•	Поле A должно быть публичным и статическим.
•	Поле B должно быть публичным и статическим.
•	Программа должна считывать данные с клавиатуры в статическом блоке.
•	Программа должна инициализировать поля A и B в статическом блоке согласно введенным с клавиатуры значениям.
•	Программа должна выводить в консоль минимальное из введенных с клавиатуры значений.
*/

public class Main {
    static
    {
        try {

            BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
            A = Integer.parseInt(rdr.readLine());
            B = Integer.parseInt(rdr.readLine());
            rdr.close();

        } catch (Exception e) {}

    }

    public static int A;
    public static int B;

    public static final int MIN = min(A, B);

    public static void main(String[] args) throws IOException {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
