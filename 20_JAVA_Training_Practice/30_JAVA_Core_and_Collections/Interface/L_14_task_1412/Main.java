package com.company;
/*
Реализовать метод printMainInfo
1. Напиши реализацию метода printMainInfo, чтобы:
1.1. Если в метод передают объект типа Drawable, у этого объекта вызывался метод draw.
1.2. Если в метод передают объект типа Movable, у этого объекта вызывался метод move.

Требования:
•	Класс Solution должен содержать реализацию метода printMainInfo с одним параметром типа Object.
•	Метод printMainInfo должен быть статическим.
•	Метод printMainInfo должен иметь самый широкий уровень доступа(public).
•	Метод printMainInfo должен вызывать у переданного ему в качестве параметра объекта метод draw,
если этот объект реализует интерфейс Drawable.
•	Метод printMainInfo должен вызывать у переданного ему в качестве параметра объекта метод move,
если этот объект реализует интерфейс Movable.
*/

public class Main {

    public static void main(String[] args) {
        Object obj = new Circle();
        Movable movable = (Movable) obj;
        Drawable drawable = new Rectangle();

        printMainInfo(drawable);
        printMainInfo(movable);
    }

    public static void printMainInfo(Object object) {
        //напишите тут ваш код
        if (object instanceof Drawable) {
            ((Drawable) object).draw();
        } else if (object instanceof Movable) {
            ((Movable) object).move();
        }
    }

    static interface Movable {
        void move();
    }

    static class Circle implements Movable {

        public void draw() {
            System.out.println("Can be drawn");
        }

        public void move() {
            System.out.println("Can be moved");
        }

    }

    static interface Drawable {
        void draw();
    }

    static class Rectangle implements Drawable {
        public void draw() {
            System.out.println("Can be drawn");
        }

        public void move() {
            System.out.println("Can be moved");
        }
    }
}
