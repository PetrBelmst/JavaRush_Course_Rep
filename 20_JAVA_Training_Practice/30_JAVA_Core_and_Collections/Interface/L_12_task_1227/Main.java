package com.company;
/*
CanFly, CanRun, CanSwim для классов Duck, Penguin, Toad
Есть интерфейсы CanFly(летать), CanSwim(плавать), CanRun(бегать).
Добавь эти интерфейсы классам Duck(утка), Penguin(пингвин), Toad(жаба)
Требования:
•	Класс Solution должен содержать интерфейс CanFly с методом void fly().
•	Класс Solution должен содержать интерфейс CanSwim с методом void swim().
•	Класс Solution должен содержать интерфейс CanRun с методом void run().
•	Класс Solution должен содержать классы Duck, Penguin, Toad.
•	Объект класса Duck должен уметь летать(поддерживать интерфейс Fly), бегать(поддерживать интерфейс Run)
и плавать(поддерживать интерфейс Swim).
•	Объект класса Penguin должен уметь бегать(поддерживать интерфейс Run) и плавать(поддерживать интерфейс Swim).
•	Объект класса Toad должен уметь только плавать(поддерживать интерфейс Swim).
*/
public class Main {

    public static void main(String[] args) {
    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }

    public class Duck implements CanFly, CanRun, CanSwim {
        @Override
        public void fly() {}
        @Override
        public void run() {}
        @Override
        public void swim() {}
    }

    public class Penguin implements CanSwim, CanRun {
        @Override
        public void run() {}
        @Override
        public void swim() {}
    }

    public class Toad implements CanSwim {
        @Override
        public void swim() {}
    }
}
