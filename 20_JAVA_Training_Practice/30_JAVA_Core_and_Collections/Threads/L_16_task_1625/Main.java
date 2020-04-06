package com.company;
/*
Взаимная блокировка
1. Разберись, как работает программа.
2. Не меняя классы T1 и T2 сделай так, чтобы их нити завершились, не обязательно успешно.
3. Метод sleep не использовать.
Требования:
•	Метод main должен запускать нить t1.
•	Метод main должен запускать нить t2.
•	Класс T1 не изменять.
•	Класс T2 не изменять.
•	Метод sleep не использовать.
•	Вывод программы должен состоять из 2х строк, информирующих о завершении нитей.
Например: "T1 was interrupted" и "T2 finished".
•	Нити t1 и t2 должны завершаться (не обязательно успешно).
*/

public class Main {

    static Thread t1 = new T1();
    static Thread t2 = new T2();

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        //t1.interrupt();
        t2.start();
        //t2.interrupt();
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            try {
                t2.join();
                System.out.println("T1 finished");
            } catch (InterruptedException e) {
                System.out.println("T1 was interrupted");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            try {
                t1.join();
                System.out.println("T2 finished");
            } catch (InterruptedException e) {
                System.out.println("T2 was interrupted");
            }
        }
    }
}