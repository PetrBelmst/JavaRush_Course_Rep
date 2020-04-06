package com.company;

/*
Неведома зверушка
Напиши метод, который определяет, какой объект передали в него.
Программа должна выводить на экран одну из надписей:
"Кот", "Тигр", "Лев", "Бык", "Животное".
Требования:
•	Класс Solution должен содержать классы Cat, Tiger, Lion, Bull, Pig.
•	Класс Solution должен содержать метод String getObjectType(Object o).
•	Метод getObjectType() должен возвращать строку "Кот" если передан объект типа Cat.
•	Метод getObjectType() должен возвращать строку "Тигр" если передан объект типа Tiger.
•	Метод getObjectType() должен возвращать строку "Лев" если передан объект типа Lion.
•	Метод getObjectType() должен возвращать строку "Бык" если передан объект типа Bull.
•	Метод getObjectType() должен возвращать строку "Животное" если передан любой другой объект.
•	Программа должна выводить на экран результат метода getObjectType().
*/

public class Main {

    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код
        if (o instanceof Cat) {
            return "Кот";
        } else if (o instanceof Tiger) {
            return "Тигр";
        } else if (o instanceof Lion) {
            return "Лев";
        } else if (o instanceof Bull) {
            return "Бык";
        } else
            return "Животное";
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}
