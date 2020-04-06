package com.company;

/*
Посетители
Напиши метод, который определяет, какой объект передали в него.
Программа должна выводить на экран одну из надписей:
"Кот", "Тигр", "Лев", "Бык", "Корова", "Животное".
Замечание:
постарайся определять тип животного как можно более точно.
Требования:
•	Класс Solution должен содержать классы Cat, Tiger, Lion, Bull, Cow, Animal.
•	Класс Solution должен содержать метод String getObjectType(Object o).
•	Метод getObjectType() должен возвращать строку "Кот", если передан объект типа Cat.
•	Метод getObjectType() должен возвращать строку "Тигр", если передан объект типа Tiger.
•	Метод getObjectType() должен возвращать строку "Лев", если передан объект типа Lion.
•	Метод getObjectType() должен возвращать строку "Бык", если передан объект типа Bull.
•	Метод getObjectType() должен возвращать строку "Корова", если передан объект типа Cow.
•	Метод getObjectType() должен возвращать строку "Животное", если передан объект типа Animal.
•	Программа должна выводить на экран результат метода getObjectType().
*/

public class Main {

    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код
        switch (o.getClass().getSimpleName()) {
            case ("Cat"): return "Кот";
            case ("Tiger"): return "Тигр";
            case ("Lion"): return "Лев";
            case ("Bull"): return "Бык";
            case ("Cow"): return "Корова";
            default: return "Животное";
        }
    }

    public static class Cat extends Animal{
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}
