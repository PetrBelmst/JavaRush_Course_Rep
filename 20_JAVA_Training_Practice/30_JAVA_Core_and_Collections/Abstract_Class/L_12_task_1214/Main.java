package com.company;

/*
Корова — тоже животное
Унаследуй класс Cow от Animal.
Реализуй все недостающие методы в классе Cow.
Требования:
•	Класс Animal должен быть абстрактным.
•	Класс Cow не должен быть абстрактным.
•	Класс Cow должен наследоваться от класса Animal.
•	Класс Cow должен реализовать абстрактный метод из класса Animal.
•	Метод getName() класса Cow должен возвращать любое имя коровы.
*/


public class Main {

    public static void main(String[] args) {

    }

    public static abstract class Animal {
        public abstract String getName();
    }

    public static class Cow extends Animal {
        @Override
        public String getName () {
            return " ";
        }
    }
}
