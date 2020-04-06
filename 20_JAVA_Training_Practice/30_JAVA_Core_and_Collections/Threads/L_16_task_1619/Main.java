package com.company;
/*
А без interrupt слабо?
Разберись, как работает программа.
Сделай так, чтобы в методе ourInterruptMethod можно было сделать так, чтобы нить TestThread завершилась сама.
Нельзя использовать метод interrupt.
Требования:
•	В классе Solution должен быть публичный статический метод ourInterruptMethod без параметров.
•	Метод run должен выводить надпись "he-he" каждые пол секунды, пока не будет вызван метод ourInterruptMethod.
•	Необходимо изменить условие цикла while в методе run.
•	Метод main должен создавать объект типа Thread передавая в конструктор объект типа TestThread.
•	Метод main должен вызывать метод start у объекта типа Thread.
•	Метод main должен вызывать метод ourInterruptMethod.
*/

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static boolean cancel = false;

    public static void ourInterruptMethod() {
        cancel = true;
    }

    public static class TestThread implements Runnable {
        public void run() {
            while (!cancel) {
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
