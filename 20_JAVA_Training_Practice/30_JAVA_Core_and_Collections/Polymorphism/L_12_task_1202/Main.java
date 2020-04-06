package com.company;

/*
Кит, коровий потомок
Переопределить метод getName в классе Whale(Кит), чтобы программа ничего не выводила на экран.
Требования:
•	Программа не должна выводить текст на экран.
•	Класс Whale должен наследоваться от класса Cow.
•	Класс Whale должен переопределять метод getName().
•	Метод main() должен вызывать метод getName() у объекта cow.
•	Реализуй метод getName() класса Whale чтобы программа ничего не выводила на экран.
•	Метод main() должен выводить на экран результат вызова метода getName().
*/

public class Main {

    public static void main(String[] args) {
        Cow cow = new Whale();
        System.out.println(cow.getName());
    }

    public static class Cow {
        public String getName() {
            return "Я - корова";
        }
    }

    public static class Whale extends Cow {
        @Override
        public String getName() {
            return "";
        }
    }
}
