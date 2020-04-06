package com.company;

/*
Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов-массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
Требования:
•	Программа не должна считывать данные с клавиатуры.
•	Метод createList должен объявлять и инициализировать переменную типа ArrayList<int[]>.
•	Метод createList должен возвращать созданный список.
•	Метод createList должен добавлять в список 5 элементов.
•	Каждый элемент в списке должен быть массивом чисел. Длина первого должна быть 5 элементов,
второго - 2, следующих - 4, 7, 0 соответственно.
•	Программа должна выводить на экран элементы всех массивов из списка. Каждый элемент с новой строки.
*/

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<>();
        int [] arr1 = {5,1,1,1,1};
        int [] arr2 = {7,1};
        int [] arr3 = {9,1,1,1};
        int [] arr4 = {8,1,1,1,1,1,1};
        int [] arr5 = {};

        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        list.add(arr5);

        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
