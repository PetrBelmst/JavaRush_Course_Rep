package com.company;
/*
Вывод стек-трейса
1. Создать таск (public static класс SpecialThread, который реализует интерфейс Runnable).
2. SpecialThread должен выводить в консоль свой стек-трейс.
Подсказка: main thread уже выводит в консоль свой стек-трейс.
Требования:
•	Добавь в класс Solution публичный статический класс SpecialThread.
•	Класс SpecialThread не должен быть унаследован от какого-либо дополнительного класса.
•	Класс SpecialThread должен реализовывать интерфейс Runnable.
•	Метод run класса SpecialThread должен выводить свой стек-трейс.
*/

public class Main {

    public static class SpecialThread implements Runnable {
        @Override
        public void run() {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            for (StackTraceElement elements : Thread.currentThread().getStackTrace()) {
                System.out.println(elements);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SpecialThread());
        thread.start();

        System.out.println("*****************");

        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            System.out.println(element);
        }
    }
}
