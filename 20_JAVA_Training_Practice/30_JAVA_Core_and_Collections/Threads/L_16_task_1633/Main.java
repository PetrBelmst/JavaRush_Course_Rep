package com.company;
/*
Отдебажим все на свете
Разобраться, что делает программа.
Почитать про UncaughtExceptionHandler - это важно.
Еще раз внимательно посмотреть программу.
Разобраться - продебажить - почему наш OurUncaughtExceptionHandler не срабатывает.
Исправить ошибку, т.е. все должно работать. :)
Ожидаемый результат в произвольном порядке:
Нить 1: My exception message
Нить 2: My exception message
Требования:
•	Метод main должен создавать нить с параметрами: commonThread и "Нить 1".
•	Метод main должен создавать нить с параметрами: commonThread и "Нить 2".
•	Метод main должен запускать две созданные нити типа Thread.
•	Метод main должен прерывать две созданные нити типа Thread.
•	Программа с помощью метода uncaughtException класса OurUncaughtExceptionHandler
должна вывести 2 сообщения.
•	Метод uncaughtException класса OurUncaughtExceptionHandler явно не вызывать.
•	Вывод программы должен содержать строки: "Нить 1: My exception message" и "Нить 2:
My exception message".
 */

public class Main {

    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");
        threadA.setUncaughtExceptionHandler(handler);
        threadB.setUncaughtExceptionHandler(handler);

        threadA.start();
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(Thread.UncaughtExceptionHandler handler) {
            setUncaughtExceptionHandler(handler);
            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}