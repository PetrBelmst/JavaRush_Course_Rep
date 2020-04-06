package com.company;

/*
Как кошка с собакой
Скрыть все внутренние переменные класса Cat и Dog.
Также скрыть все методы, кроме тех, с помощью которых эти классы взаимодействуют друг с другом.

Требования:
•	Переменные класса Cat должны быть скрыты.
•	Переменные класса Dog должны быть скрыты.
•	Методы класса Cat должы быть скрыты.
•	Методы класса Dog должы быть скрыты.
•	Методы, с помощью которых классы Cat и Dog взаимодействуют друг с другом, должны быть публичными.
*/

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Vaska", 5);
        Dog dog = new Dog("Sharik", 4);

        cat.isDogNear(dog);
        dog.isCatNear(cat);
    }
}

class Cat {
    private String name;
    private int speed;

    public Cat(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    private String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isDogNear(Dog dog) {
        return this.speed > dog.getSpeed();
    }
}

class Dog {
    private String name;
    private int speed;

    public Dog(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    private String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isCatNear(Cat cat) {
        return this.speed > cat.getSpeed();
    }
}
