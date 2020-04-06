package com.company;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
Решаем пример
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.
Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.
Пример вывода:
3 + 6 = 9
Требования:
•	Класс Solution должен содержать класс TestString.
•	Класс Solution должен содержать публичное статическое поле testString типа TestString,
которое сразу проинициализировано.
•	Класс TestString должен содержать публичный void метод printSomething().
•	Метод printSomething() класса TestString должен выводить на экран строку "3 + 6 = ".
•	Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй
PrintStream c параметром конструктора ByteArrayOutputStream).
•	Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода
в консоль объекта System.out.
•	Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
•	Метод main(String[] args) класса Solution должен модифицировать строку выведенную методом
printSomething() согласно заданию, и выводить её в консоль.
*/
public class Main {

    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String[] s = outputStream.toString().split(" ");

        System.setOut(console);

        int a = Integer.valueOf(s[0]);
        int b = Integer.valueOf(s[2]);
        int c = 0;

        switch (s[1]) {
            case "+": c = a + b; break;
            case "-": c = a - b; break;
            case "*": c = a * b; break;
        }
        System.out.print(a + " " + s[1] + " " + b + " " + s[3] + " " + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}