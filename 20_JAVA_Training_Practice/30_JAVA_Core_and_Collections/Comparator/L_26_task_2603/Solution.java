package com.company;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напиши public static компаратор CustomizedComparator, который будет:
1. В конструкторе принимать массив компараторов.
2. Сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т.
В конструктор передается как минимум один компаратор.

Требования:
•	Класс Solution должен содержать public static компаратор CustomizedComparator.
•	Класс CustomizedComparator должен содержать приватное поле comparators типа Comparator<T>[].
•	Класс CustomizedComparator должен содержать конструктор с параметром vararg компараторов.
•	Метод compare() класса CustomizedComparator должен сравнивать объекты в порядке,
соответствующем последовательности компараторов comparators.
*/
public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T> [] comparators;
        CustomizedComparator (Comparator<T>... comparators) {
            this.comparators = comparators;
        }
        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator element : comparators) {
                result = element.compare(o1, o2);
                if (result != 0) {
                    break;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
	// write your code here


    }
}
