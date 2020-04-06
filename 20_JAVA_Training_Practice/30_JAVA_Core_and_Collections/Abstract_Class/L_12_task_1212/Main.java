package com.company;

/*
«Исправь код», часть 1
Исправь код, чтобы программа компилировалась.
Подсказка:
метод getChild должен остаться абстрактным.
Требования:
•	Класс Pet должен быть статическим.
•	Класс Pet должен иметь два метода.
•	Метод getChild() должен быть абстрактным.
•	Класс Pet должен быть объявлен с модификатором, который запрещает создавать конкретные объекты этого класса.
*/

public class Main {

    public static void main(String[] args) {}

    public static abstract class Pet {
        public String getName() {
            return "Я - котенок";
        }
        public abstract Pet getChild();
    }
}
