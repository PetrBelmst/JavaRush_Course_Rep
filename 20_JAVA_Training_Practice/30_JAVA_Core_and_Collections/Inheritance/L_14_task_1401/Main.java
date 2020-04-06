package com.company;
/*
Bingo!
Исправь строчку 'Object animal = new Pet();' в методе main так, чтобы программа вывела "Bingo!".

Требования:
•	Класс Cat должен наследоваться от класса Pet.
•	Класс Tiger должен наследоваться от класса Cat.
•	В переменной Object animal должен храниться объект который будет одновременно являться и Pet, и Cat, и Tiger.
•	Программа должна выводить на экран: "Bingo!".
*/

public class Main {

    public static void main(String[] args) {
        Object animal = new Tiger();
        boolean isCat = animal instanceof Cat;
        boolean isTiger = animal instanceof Tiger;
        boolean isPet = animal instanceof Pet;

        printResults(isCat, isTiger, isPet);
    }

    private static void printResults(boolean cat, boolean tiger, boolean pet) {
        if (cat && tiger && pet) System.out.println("Bingo!");
    }

    static class Pet {
    }

    static class Cat extends Pet {
    }

    static class Tiger extends Cat {
    }
}
