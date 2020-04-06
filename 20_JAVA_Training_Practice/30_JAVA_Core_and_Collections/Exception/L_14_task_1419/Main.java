package com.company;

import java.util.ArrayList;
import java.util.List;

/*
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.
Требования:
•	Список exceptions должен содержать 10 элементов.
•	Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
•	Все элементы списка exceptions должны быть уникальны.
•	Метод initExceptions должен быть статическим.
*/

public class Main {

    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        //напишите тут ваш код
        try {
            int [] a = new int[2];
            a[3] = 2;
        } catch (Exception s) {
            exceptions.add(s);
        }

        Exception d = new NegativeArraySizeException();
        exceptions.add(d);

        Exception f = new RuntimeException();
        exceptions.add(f);

        Exception g = new ArrayStoreException();
        exceptions.add(g);

        Exception h = new ClassCastException();
        exceptions.add(h);

        Exception j = new ClassNotFoundException();
        exceptions.add(j);

        Exception k = new StringIndexOutOfBoundsException();
        exceptions.add(k);

        Exception l = new CloneNotSupportedException();
        exceptions.add(l);

        Exception z = new IllegalArgumentException();
        exceptions.add(z);
    }
}

















