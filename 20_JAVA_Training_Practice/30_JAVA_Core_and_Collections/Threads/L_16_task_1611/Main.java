package com.company;
/*
Часы
1. Разберись, что делает программа.
2. Реализуй логику метода printTikTak:
2.1. Через первые полсекунды должна выводиться в консоль фраза: Tik
2.2. Через вторые полсекунды должна выводиться в консоль фраза: Tak
Требования:
•	Метод printTikTak должен выводить две строчки: "Tik" и "Tak".
•	Метод printTikTak должен работать примерно секунду.
•	Метод printTikTak должен два раза заснуть на полсекунды. Используй метод Thread.sleep(500).
•	В консоли не должно быть сообщений после фразы "Double-check".
•	Метод main должен создавать объект типа Clock.
*/

public class Main {

    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread.sleep(2000);
        isStopped = true;
        System.out.println("The clock has to be stopped");
        Thread.sleep(2000);
        System.out.println("Double-check");
    }

    public static class Clock extends Thread {
        public Clock() {
            setPriority(MAX_PRIORITY);
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTikTak();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTikTak() throws InterruptedException {
            //add your code here - добавь код тут
            Thread.sleep(500);
            System.out.println("Tik");
            Thread.sleep(500);
            System.out.println("Tak");
        }
    }
}