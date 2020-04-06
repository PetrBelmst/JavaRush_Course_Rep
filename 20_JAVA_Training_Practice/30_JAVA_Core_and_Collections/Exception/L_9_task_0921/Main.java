package com.company;

/*
Метод в try..catch

Написать программу, которая будет вводить числа с клавиатуры.
Код по чтению чисел с клавиатуры должен быть в методе readData.
Код внутри readData обернуть в try..catch.
Если пользователь ввёл какой-то текст, вместо ввода числа,
то метод должен перехватить исключение и вывести на экран все ранее введенные числа в качестве результата.
Числа выводить с новой строки сохраняя порядок ввода.
Требования:
•	Программа должна считывать данные с клавиатуры.
•	Метод main не изменять.
•	Метод main не должен кидать исключений.
•	Метод readData должен содержать блок try..catch.
•	Если пользователь ввел текст, а не число, программа должна вывести все ранее введенные числа.
19
10
16
17
9
3
строка
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        readData();
    }
    public static void readData() {

        ArrayList <Integer> list = new ArrayList();

        try {
            BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                list.add(Integer.parseInt(rdr.readLine()));
            }
        }
        catch (NumberFormatException e) {
            for (Object t : list) {
                System.out.println(t);
            }
        }
        catch (Exception e) {}
    }
}
