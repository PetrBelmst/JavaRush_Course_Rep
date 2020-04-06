package com.company;

import java.io.Serializable;

/*
Минимум изменений
Используя минимум изменений кода сделайте так, чтобы сериализация класса C стала возможной.
Требования:
•	В классе Solution должен существовать класс A.
•	В классе Solution должен существовать класс B.
•	В классе Solution должен существовать класс C.
•	Класс B должен быть потомком класса A.
•	Класс C должен быть потомком класса B.
•	Класс A должен поддерживать интерфейс Serializable.
•	Класс B не должен явно поддерживать интерфейс Serializable.
•	Класс C не должен явно поддерживать интерфейс Serializable.
*/
public class Main {

    public class A implements Serializable {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) {

    }
}
