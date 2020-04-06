package com.company;

import java.awt.*;

/*
Большая лисица — это такая лисица
1. Исправь класс BigFox так, чтобы программа компилировалась.
Требования:
•	Интерфейс Animal должен быть реализован в классе Fox.
•	В классе Fox должен быть реализован только один метод(getName).
•	В интерфейсе Animal должен быть объявлен метод getColor.
•	Класс BigFox должен быть потомком класса Fox.

*/
public class Main {

    public static void main(String[] args) throws Exception {
        Fox bigFox = new BigFox();
        System.out.println(bigFox.getName());
        System.out.println(bigFox.getColor());

    }

    public interface Animal {
        Color getColor();
    }

    public static abstract class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }

    public static class BigFox extends Fox {
        public Color bigFoxColor() {
            return Color.GRAY;
        }

        @Override
        public Color getColor() {
            return this.bigFoxColor();
        }
    }
}
