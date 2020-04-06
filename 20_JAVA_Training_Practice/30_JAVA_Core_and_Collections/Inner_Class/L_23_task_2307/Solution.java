package com.company;
/*
Как выбрать нужное?
В методе main присвой объекту Object obj экземпляр класса TEST.
Не изменяй ничего кроме метода main.

Требования:
•	В классе Solution должно существовать поле TEST.
•	В классе Solution должен существовать класс TEST.
•	В классе Solution должно существовать поле obj.
•	В методе main в поле obj должен быть сохранен объект типа TEST(экземпляр класса TEST).
*/
public class Solution {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {
        obj = Solution.TEST;
        System.out.println(obj);
        obj = new TEST();
    }
}
