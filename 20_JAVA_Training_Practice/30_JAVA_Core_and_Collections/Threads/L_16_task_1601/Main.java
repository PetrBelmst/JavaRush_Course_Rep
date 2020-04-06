package com.company;
/*
My first thread
Создать public static class TestThread - нить с интерфейсом Runnable.
TestThread должен выводить в консоль "My first thread".

Требования:
•	Добавь в класс Solution публичный статический класс TestThread.
•	Класс TestThread должен реализовывать интерфейс Runnable.
•	Метод run класса TestThread должен выводить "My first thread".
•	Программа должна вывести "My first thread".
•	Метод main не изменять.
*/

public class Main {

    public static void main(String[] args) {
        TestThread task = new TestThread();
        new Thread(task).start();
    }

    public static class TestThread implements Runnable {
        @Override
        public void run() {
            System.out.println("My first thread");
        }
    }
}