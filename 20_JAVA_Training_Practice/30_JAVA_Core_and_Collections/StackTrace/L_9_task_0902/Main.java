package com.company;

/*
И снова StackTrace
Написать пять методов, которые вызывают друг друга.
Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.
Требования:
•	В классе должно быть 5 методов (метод main не учитывать).
•	Каждый метод должен вызывать следующий: main вызывать method1, method1 вызывать method2 и т.д.
•	Каждый метод должен возвращать имя метода, вызвавшего его.
•	Для получения имени вызвавшего метода, используй метод getMethodName.
*/

public class Main {

    public static void main(String[] args) {
        method1();
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " :" + Thread.currentThread().getStackTrace().length);
        System.out.println(Thread.currentThread().getStackTrace()[0].getMethodName() + " :" + Thread.currentThread().getStackTrace().length);
    }

    public static String method1() {
        method2();
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " :" + Thread.currentThread().getStackTrace().length);
        System.out.println(Thread.currentThread().getStackTrace()[0].getMethodName() + " :" + Thread.currentThread().getStackTrace().length);
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method2() {
        method3();

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " :" + Thread.currentThread().getStackTrace().length);
        System.out.println(Thread.currentThread().getStackTrace()[0].getMethodName() + " :" + Thread.currentThread().getStackTrace().length);
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method3() {
        method4();

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " :" + Thread.currentThread().getStackTrace().length);
        System.out.println(Thread.currentThread().getStackTrace()[0].getMethodName() + " :" + Thread.currentThread().getStackTrace().length);
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method4() {
        method5();

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " :" + Thread.currentThread().getStackTrace().length);
        System.out.println(Thread.currentThread().getStackTrace()[0].getMethodName() + " :" + Thread.currentThread().getStackTrace().length);
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method5() {

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " :" + Thread.currentThread().getStackTrace().length);
        System.out.println(Thread.currentThread().getStackTrace()[0].getMethodName() + " :" + Thread.currentThread().getStackTrace().length);
        return Thread.currentThread().getStackTrace()[2].getMethodName();

    }
}