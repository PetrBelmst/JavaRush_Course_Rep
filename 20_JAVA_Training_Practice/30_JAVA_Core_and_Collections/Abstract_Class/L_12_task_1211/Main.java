package com.company;

/*
Абстрактный класс Pet
Сделать класс Pet абстрактным.
Требования:
•	Программа не должна выводить текст на экран.
•	Класс Pet должен быть статическим.
•	Класс Pet должен быть абстрактным.
•	Класс Pet должен иметь один метод getName().

*/

public class Main {

    public static void main(String[] args) {}

    public static abstract class Pet {
        public String getName() {
            return "Я - котенок";
        }
    }
}
