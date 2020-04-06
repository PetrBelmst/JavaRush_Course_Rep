package com.company;
/*
Runtime исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен всегда кидать Runtime исключение ClassCastException.
Напиши реализацию метода methodThrowsNullPointerException(). Он должен всегда кидать Runtime исключение NullPointerException.
Кинуть исключение (throw) явно нельзя.
Требования:
•	Метод methodThrowsClassCastException класса veryComplexClass не должен использовать ключевое слово throw.
•	Метод methodThrowsNullPointerException класса veryComplexClass не должен использовать ключевое слово throw.
•	Метод methodThrowsClassCastException класса veryComplexClass должен бросать исключение ClassCastException.
•	Метод methodThrowsNullPointerException класса veryComplexClass должен бросать исключение NullPointerException.
*/
public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object o = new Character('d');
        Integer i = (Integer) o;
    }

    public void methodThrowsNullPointerException() {
        int[] arr = null;
        int l = arr.length;
    }

    public static void main(String[] args) {

    }
}
