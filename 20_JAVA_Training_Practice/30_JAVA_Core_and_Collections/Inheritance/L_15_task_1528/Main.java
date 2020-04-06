package com.company;
/*
ООП. Hrivna — тоже деньги
Исправь класс Hrivna так, чтоб избежать возникновения ошибки StackOverflowError.

Требования:
•	Класс Hrivna должен быть потомком класса Money.
•	В классе Hrivna должен быть реализован метод getAmount.
•	Метод getAmount в классе Hrivna должен возвращать значение поля amount.
•	В процессе выполнения программы НЕ должны возникать исключения или ошибки.
ООП. Hrivna — тоже деньги
*/

public class Main {

    public static void main(String[] args) {
        System.out.println(new Hrivna().getAmount());
    }

    public static abstract class Money {
        abstract Money getMoney();

        public Object getAmount() {
            return getMoney().getAmount();
        }
    }

    //add your code below - добавь код ниже
    public static class Hrivna extends Money {
        private double amount = 123d;

        @Override
        Money getMoney() {
            return null;
        }

        @Override
        public Object getAmount() {
            return amount;
        }
    }
}
