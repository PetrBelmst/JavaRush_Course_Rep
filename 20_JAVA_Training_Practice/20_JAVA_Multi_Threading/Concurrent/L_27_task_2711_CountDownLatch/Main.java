package com.company;

import java.util.concurrent.CountDownLatch;

/*
CountDownLatch
Дана стандартная реализация методологии wait-notify.
Почитай про CountDownLatch и перепиши тело метода someMethod используя поле latch.
Весь лишний код удали из класса.

Требования:
•	Из класса Solution должно быть удалено поле lock.
•	Из метода someMethod должен быть удален synchronized блок.
•	В методе someMethod должен быть вызван метод await без параметров у объекта сохраненного
в поле latch.
•	В методе someMethod должен быть вызван метод retrieveValue.
•	В методе someMethod должен быть вызван метод countDown у объекта сохраненного в поле latch.
*/
public class Main {

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        latch.countDown();
        latch.wait();
        retrieveValue();
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) {

    }
}