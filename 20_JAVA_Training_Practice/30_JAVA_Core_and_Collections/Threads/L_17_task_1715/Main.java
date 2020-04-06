package com.company;

import java.util.ArrayList;
import java.util.List;

/*
Аптека
Реализуй интерфейс Runnable в классах Apteka и Person.
Все нити должны работать пока не isStopped.
Логика для Apteka: drugsController должен сделать закупку случайного лекарства (getRandomDrug)
в количестве (getRandomCount) и подождать 300 мс.
Логика для Person: drugsController должен сделать продажу случайного лекарства (getRandomDrug)
в количестве (getRandomCount) и подождать 100 мс.
Расставь synchronized там, где это необходимо.
Требования:
•	Класс Solution должен содержать public static поле drugsController типа DrugsController.
•	Класс Solution должен содержать public static поле isStopped типа boolean.
•	Класс Solution должен содержать private static void метод waitAMoment(), который должен ждать 100 мс.
•	Класс Apteka должен реализовывать интерфейс Runnable.
•	Нить Apteka должна работать пока isStopped = false.
•	Нить Apteka должна использовать drugsController для закупки случайного лекарства (getRandomDrug)
в количестве (getRandomCount).
•	Нить Apteka должна ждать 300мс между закупками, используя метод waitAMoment().
•	Класс Person должен реализовывать интерфейс Runnable.
•	Нить Person должна работать пока isStopped = false.
•	Нить Person должна использовать drugsController для продажи случайного лекарства (getRandomDrug)
в количестве (getRandomCount).
•	Нить Person должна ждать 100мс между закупками, используя метод waitAMoment().
•	Методы класса DrugsController должны быть synchronized.

*/
public class Main {

    public volatile static DrugsController drugsController = new DrugsController();
    public volatile static boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Thread apteka = new Thread(new Apteka());
        Thread man = new Thread(new Person(), "Мужчина");
        Thread woman = new Thread(new Person(), "Женщина");

        apteka.start();
        man.start();
        woman.start();

        Thread.sleep(1000);
        isStopped = true;
    }

    public static class Apteka implements Runnable {
        @Override
        public void run() {
            try {
                while (!isStopped) {
                    drugsController.buy(getRandomDrug(), getRandomCount());
                    Main.waitAMoment();
                    Main.waitAMoment();
                    Main.waitAMoment();
                }
            } catch (Exception e) {}

        }
    }

    public static class Person implements Runnable {
        @Override
        public void run() {
            try {
                while (!isStopped) {
                    drugsController.sell(getRandomDrug(), getRandomCount());
                    Main.waitAMoment();
                }
            } catch (Exception e) {}
        }
    }

    public synchronized static int getRandomCount() {
        return (int) (Math.random() * 3) + 1;
    }

    public synchronized static Drug getRandomDrug() {
        int index = (int) ((Math.random() * 1000) % (drugsController.allDrugs.size()));
        List<Drug> drugs = new ArrayList<>(drugsController.allDrugs.keySet());
        return drugs.get(index);
    }

    private synchronized static void waitAMoment() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
