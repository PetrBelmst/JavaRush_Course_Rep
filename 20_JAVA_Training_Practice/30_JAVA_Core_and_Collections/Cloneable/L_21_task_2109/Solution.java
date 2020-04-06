package com.company;
/*
Запретить клонирование
Разреши клонировать класс А
Запрети клонировать класс B
Разреши клонировать класс C
Не забудь о методах equals и hashCode!

Требования:
•	Класс A должен поддерживать интерфейс Cloneable.
•	Класс B должен быть потомком класса A.
•	При объявлении класса B не должно быть явно указано implements Cloneable.
•	Метод clone в классе B должен быть переопределен таким образом, чтобы при попытке клонирования
объекта класса B возникало исключение CloneNotSupportedException.
•	Класс C должен быть потомком класса B.
•	Клонирование объектов класса C должно завершаться успешно.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
        public A clone() throws CloneNotSupportedException {
            return (A) super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        public C clone() throws CloneNotSupportedException {
            C c = new C(getI(), getJ(), getName());
            return c;
        }
    }

    public static void main(String[] args) {

    }
}