package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Осваивание статического блока
1. В отдельных файлах создать классы Plane и Helicopter, реализующие интерфейс CanFly.
2. Класс Plane должен иметь конструктор с параметром int - количество перевозимых пассажиров.
3. В статическом методе reset класса Solution:
3.1. Считать с консоли параметр типа String.
3.2. Если параметр равен "helicopter", то статическому объекту CanFly result присвоить объект класса Helicopter.
3.3. Если параметр равен "plane", то считать второй параметр типа int(количество пассажиров),
статическому объекту CanFly result присвоить объект класса Plane.
4. В статическом блоке инициализировать CanFly result вызвав метод reset.
5. Закрыть поток ввода методом close().

Требования:
•	Класс Plane должен быть создан в отдельном файле и реализовывать интерфейс CanFly.
•	Класс Helicopter должен быть создан в отдельном файле и реализовывать интерфейс CanFly.
•	Класс Plane должен иметь конструктор с параметром int.
•	В классе Solution должен быть реализован метод public static void reset().
•	Метод reset должен считывать строки с клавиатуры.
•	Если введенная строка равна "helicopter", в переменную result должен быть сохранен объект типа Helicopter.
•	Если введенная строка равна "plane", в переменную result должен быть сохранен объект типа Plane.
•	Поле result класса Solution должно быть инициализировано в статическом блоке путем вызова метода reset.
*/

public class Main {

    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputLine = rdr.readLine();
            if (inputLine.equals("helicopter")) {
                result = new Helicopter();
                rdr.close();
            } else if (inputLine.equals("plane")) {
                int passQTY = Integer.parseInt(rdr.readLine());
                result = new Plane(passQTY);
            }
            rdr.close();

        } catch (Exception e) {}
    }
}
