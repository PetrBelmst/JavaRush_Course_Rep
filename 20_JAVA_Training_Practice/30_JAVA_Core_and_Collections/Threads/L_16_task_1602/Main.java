package com.company;
/*
My second thread
1. Создать public static класс TestThread, унаследованный от класса Thread.
2. Создать статик блок внутри TestThread, который выводит в консоль "it's a static block inside TestThread".
3. Метод run должен выводить в консоль "it's a run method".
Требования:
•	Добавь в класс Solution публичный статический класс TestThread.
•	Класс TestThread должен быть унаследован от класса Thread.
•	Класс TestThread не должен реализовывать какие-либо дополнительные интерфейсов.
•	Создать статик блок внутри TestThread, который выводит в консоль "it's a static block inside TestThread".
•	Метод run класса TestThread должен выводить "it's a run method".
•	Метод main не изменять.
*/

public class Main {

    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();
    }

    public static class TestThread extends Thread {
        @Override
        public void run() {
            System.out.println("it's a run method");
        }

        static {
            System.out.println("it's a static block inside TestThread");
        }
    }
}
