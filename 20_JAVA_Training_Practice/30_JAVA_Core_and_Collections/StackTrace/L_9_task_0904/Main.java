package com.company;

/*
Стек-трейс длиной 10 вызовов
Напиши код, чтобы получить стек-трейс длиной 10 вызовов. Метод main изменять нельзя.
Требования:
•	В классе должно быть 10 методов (метод main не учитывать).
•	В переменной stackTraceLength должно получиться значение 10.
•	Каждый метод должен вызывать другой метод.
•	Используй метод Thread.currentThread().getStackTrace().
*/

public class Main {

    public static void main(String[] args) {
        System.out.println(method1().length);
        System.out.println(method9().length);
        System.out.println(method10().length);
        int stackTraceLength = method1().length - method10().length + 1;
    }

    public static StackTraceElement[] method1() {
        return method2();
    }

    public static StackTraceElement[] method2() {
        return method3();
    }

    public static StackTraceElement[] method3() {
        return method4();
    }

    public static StackTraceElement[] method4() {
        return method5();
    }

    public static StackTraceElement[] method5() {
        return method6();
    }

    public static StackTraceElement[] method6() {
        return method7();
    }

    public static StackTraceElement[] method7() {
        return method8();
    }

    public static StackTraceElement[] method8() {
        return method9();
    }

    public static StackTraceElement[] method9() {
        return method10();
    }

    public static StackTraceElement[] method10() {
        return Thread.currentThread().getStackTrace();
    }
}
