package com.company;

/*
Десять котов.

Есть класс кот - Cat, с полем "имя" (String).
Создать словарь Map<String, Cat> и добавить туда 10 котов в виде "Имя"-"Кот".
Получить из Map множество(Set) всех котов и вывести его на экран.
Требования:
•	Программа не должна считывать данные с клавиатуры.
•	Метод createMap должен создавать новый объект HashMap<String, Cat>.
•	Метод createMap должен добавлять в словарь 10 котов в виде «Имя»-«Кот».
•	Метод createMap должен возвращать созданный словарь.
•	Метод convertMapToSet должен создать и вернуть множество котов, полученных из переданного словаря.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> catsInMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            catsInMap.put("q"+i, new Cat("q"+i));
        }
        return catsInMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> catsInSet = new HashSet<>(map.values());
        return catsInSet;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;
        public Cat(String name) {
            this.name = name;
        }
        public String toString() {
            return "Cat " + this.name;
        }
    }
}
