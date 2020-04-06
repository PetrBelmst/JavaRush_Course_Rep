package com.company;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

/*
Magic class
В пакете java.util.concurrent найди такую реализацию List, у которой:
1. Итератор не содержит какие-либо данные, вставленные в список после создания итератора;
2. Внутри данные хранятся в виде массива;
3. Итератор гарантированно не бросает ConcurrentModificationException;
4. Допускаются все элементы включая null;
5. Исправь строку List<String> list = null ... в методе main.

Требования:
•	Класс Solution изменять нельзя.
•	Реализацию методов startUpdatingThread и stopUpdatingThread менять нельзя.
•	Реализацию метода copyOnWriteSolution менять нельзя.
•	Добавь в main создание нужного экземпляра List согласно заданию.
*/
public class Solution {

    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        List<String> list = new CopyOnWriteArrayList<>();

        solution.startUpdatingThread(list);
        solution.copyOnWriteSolution(list);
        solution.stopUpdatingThread();
    }

    public void copyOnWriteSolution(List<String> list) throws InterruptedException {
        System.out.println("size = " + list.size());
        System.out.println();
        Thread.sleep(20);
        for (String element : list) {   //создает новую копию на момент создания итератора
            System.out.println("Element: " + element);
        }
        System.out.println("size = " + list.size());
        System.out.println();
        Thread.sleep(20);

        for (String element : list) {  //создает новую копию на момент создания итератора
            System.out.println("Element2: " + element);
        }
        System.out.println("size = " + list.size());
        stopUpdatingThread();
    }

    public void stopUpdatingThread() throws InterruptedException {
        t.stop();
        t.join();
    }

    private Thread t;

    private void startUpdatingThread(final List<String> list) {
        t = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                list.add("s" + ThreadLocalRandom.current().nextInt());
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                }
            }
        });
        t.start();
    }
}