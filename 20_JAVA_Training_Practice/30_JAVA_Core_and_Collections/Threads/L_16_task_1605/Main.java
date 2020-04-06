package com.company;

import java.util.Date;

/*
Поговорим о музыке
1. Измени класс Violin так, чтоб он стал таском для нити. Используй интерфейс MusicalInstrument
2. Реализуй необходимый метод в нити Violin. Реализация должна быть следующей:
2.1. Считай время начала игры - метод startPlaying().
2.2. Подожди 1 секунду - метод sleepNSeconds(int n), где n - количество секунд.
2.3. Считай время окончания игры - метод stopPlaying().
2.4. Выведи на консоль продолжительность игры в миллисекундах. Используй методы из пунктов 2.1 и 2.3.

Пример "Playing 1002 ms".

Требования:
•	Класс Violin не должен быть унаследован от какого-либо дополнительного класса.
•	Класс Violin должен реализовывать интерфейс MusicalInstrument.
•	Метод run класса Violin должен вызывать метод startPlaying.
•	Метод run класса Violin должен вызывать метод sleepNSeconds с параметром 1 секунда.
•	Метод run класса Violin должен вызывать метод stopPlaying.
•	Метод run класса Violin должен выводить на консоль продолжительность игры в миллисекундах. Используй формат из примера.
*/

public class Main {

    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument {
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            //System.out.println(this.owner + " is starting to play");
            return new Date();
        }

        public Date stopPlaying() {
            //System.out.println(this.owner + " is stopping playing");
            return new Date();
        }

        @Override
        public void run() {
            long start = startPlaying().getTime();
            sleepNSeconds(1);
            long stop = stopPlaying().getTime();
            long dif = stop - start;
            System.out.println("Playing " + dif + " ms");
        }
    }
}
