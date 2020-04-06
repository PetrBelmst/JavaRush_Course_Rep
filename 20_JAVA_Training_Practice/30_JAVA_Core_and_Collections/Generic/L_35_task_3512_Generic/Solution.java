package com.company;
/*
Генератор объектов
Разберись с текущими классами.
Метод newInstance класса Generator должен создавать Event для каждого нового вызова,
однако сейчас компилятор ругается на синтаксис.
Переделай класс Generator так, что бы конструкция стала рабочей.

Подсказка: Для создания объекта потребуется использовать метод Class<T>.newInstance().

Требования:
•	Класс Generator должен быть параметризован типом Т.
•	Класс Generator должен иметь поле типа Class, которое параметризовано типом Т.
•	Класс Generator должен иметь конструктор, который инициализирует поле типа Class.
•	Метод newInstance в классе Generator должен создавать и возвращать объект типа Т.
*/
public class Solution {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Generator<Event> eventGenerator = new Generator<>(Event.class);

        System.out.println(eventGenerator.newInstance().getId());
        System.out.println(eventGenerator.newInstance().getId());
        System.out.println(eventGenerator.newInstance().getId());
    }

}
