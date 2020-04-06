package com.company;
/*
Почитать в инете про медиану выборки
Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.
Пример входящего массива:
13, 8, 15, 5, 17
медиана - 13
Отсортированный масив:
13, 15, 17, 8, 5
Требования:
•	Программа не должна выводить текст в консоль.
•	Программа не должна считывать данные с консоли.
•	Класс Solution должен содержать публичный статический метод Integer[] sort(Integer[] array).
•	Метод sort(Integer[] array) класса Solution должен сортировать данные в массиве по удаленности от его медианы.
*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Integer[] array = {13, 8, 15, 5, 17};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int median;
        median = (array.length % 2 == 0)
                ? (array[array.length / 2] + array[array.length / 2 -1]) / 2
                : array[array.length / 2];

        Comparator <Integer> comparatorByMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (Math.abs(median - o1) - (median - o2));
            }
        };
        Arrays.sort(array, comparatorByMedian);
        return array;
    }
}





























