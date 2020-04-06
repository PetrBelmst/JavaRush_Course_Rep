package com.company;

/*
Возвращаем StackTrace
Написать пять методов, которые вызывают друг друга.
Каждый метод должен возвращать свой StackTrace.
Требования:
•	В классе должно быть 5 методов (метод main не учитывать).
•	Каждый метод должен вызывать следующий: main вызывать method1, method1 вызывать method2 и т.д.
•	Каждый метод должен возвращать свой StackTrace.
•	Для получения StackTrace воспользуйся Thread.currentThread().getStackTrace().
*/

public class Main {

    public static void main(String[] args) {
        method1();
    }

    public static StackTraceElement[] method1() {
        method2();
        StackTraceElement[] m1 = Thread.currentThread().getStackTrace();
        return m1;
    }

    public static StackTraceElement[] method2() {
        method3();
        StackTraceElement[] m2 = Thread.currentThread().getStackTrace();
        return m2;
    }

    public static StackTraceElement[] method3() {
        method4();
        StackTraceElement[] m3 = Thread.currentThread().getStackTrace();
        return m3;
    }

    public static StackTraceElement[] method4() {
        method5();
        StackTraceElement[] m4 = Thread.currentThread().getStackTrace();
        return m4;
    }

    public static StackTraceElement[] method5() {
        StackTraceElement[] m5 = Thread.currentThread().getStackTrace();
        return m5;
    }
}
