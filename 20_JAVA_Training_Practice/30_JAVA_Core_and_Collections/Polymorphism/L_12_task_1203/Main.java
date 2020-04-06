package com.company;

/*
Кесарю — кесарево
Переопределить метод getChild в классах Cat(кот) и Dog(собака), чтобы кот порождал кота, а собака - собаку.
Требования:
•	Класс Cat должен наследоваться от класса Pet.
•	Класс Dog должен наследоваться от класса Pet.
•	Класс Cat должен переопределять метод getChild() чтобы кот порождал кота.
•	Класс Dog должен переопределять метод getChild() чтобы собака порождала собаку.
•	Метод main() должен вызывать метод getChild() у объекта типа Cat.
•	Метод main() должен вызывать метод getChild() у объекта типа Dog.
*/

public class Main {

    public static void main(String[] args) {
        Pet pet1 = new Cat();
        Pet cat = pet1.getChild();

        Pet pet2 = new Dog();
        Pet dog = pet2.getChild();
    }

    public static class Pet {
        public Pet getChild() {
            return new Pet();
        }
    }

    public static class Cat extends Pet {
        @Override
        public Pet getChild() {
            return new Cat();
        }
    }

    public static class Dog extends Pet {
        @Override
        public Pet getChild() {
            return new Dog();
        }
    }
}
