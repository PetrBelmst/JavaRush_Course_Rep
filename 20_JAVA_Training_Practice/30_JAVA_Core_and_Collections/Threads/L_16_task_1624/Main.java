package com.company;
/*
Последовательные выполнения нитей
1. Разберись, что делает программа.
2. Сделай так, чтоб программа сначала выводила результат нити,
а когда нить завершится - продолжила метод main.
3. Пример выходных данных:
inside MyThread 0
inside MyThread 1
...
inside MyThread 9
inside main 0
inside main 1
...
inside main 9
Требования:
•	Метод main должен вызывать метод start у нити t.
•	Метод main должен вызывать метод join у нити t.
•	Сначала программа должна вывести 10 строк начинающихся с "inside MyThread".
•	В конце программа должна вывести 10 строк начинающихся с "inside main".
•	Всего программа должна вывести 20 строк.
*/

public class Main {

    public static MyThread t = new MyThread();
    static String message = "inside main ";

    public static void main(String a[]) throws Exception {
        t.start();
        t.join();
        for (int i = 0; i < 10; i++) {
            System.out.println(message + i);
            sleep();
        }
    }

    public static void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }

    static class MyThread extends Thread {
        String message = "inside MyThread ";

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(message + i);
                Main.sleep();
            }
        }
    }
}