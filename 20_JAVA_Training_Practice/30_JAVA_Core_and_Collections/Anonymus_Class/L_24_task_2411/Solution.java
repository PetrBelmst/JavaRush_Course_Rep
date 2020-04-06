package com.company;
/*
Вспомним наследование
Исправить наследование во всех классах, чтобы вывод метода main был CCBAYS.
Требования:
•	Вывод на экран должен соответствовать условию задачи.
•	Класс C должен поддерживать интерфейс JustAnInterface.
•	Класс B должен быть потомком класса C.
•	Класс Solution должен быть потомком класса C.
*/
public class Solution extends C {

    private class A {
        protected String value = "A";

        public A() {
            System.out.print(value);
        }
    }

    private A a = new A() {
        { //у анонимных классов нет своих конструкторов, но что-то можно сделать в блоке инициализации класса
            value = "Y";
            if (super.getClass().getName().contains(".Solution$")) {
                System.out.print(value);
            }
        }
    };

    public Solution() {
        System.out.print("S");
    }

    public static void main(String[] args) {
        new Solution();
    }
}



