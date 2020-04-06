package com.company;

import java.util.List;

/*
Знакомство с дженериками
Параметризируй классы SomeClass и Solution следующим образом:
1. SomeClass должен работать с типами, которые наследуются от Number;
2. Solution должен работать с типами, которые наследуются от List, который в свою очередь параметризируется типом SomeClass.

Требования:
•	Класс SomeClass должен работать с типами которые наследуются от Number.
•	Класс Solution должен работать с типами, которые наследуются от List, который в свою очередь параметризируется типом SomeClass.
•	Класс SomeClass должен быть публичным.
•	Класс SomeClass должен быть статическим.
•	Класс SomeClass должен находиться внутри класса Solution.
*/
public class Solution<T extends List<Solution.SomeClass>> {
    public static class SomeClass<T extends Number> {
    }

    public static void main(String[] args) {

    }
}