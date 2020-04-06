package com.company;
/*
Второй вариант deadlock
В методе secondMethod расставь synchronized блоки так, чтобы при использовании класса Solution
нитями образовывался deadlock.

Требования:
•	В методе secondMethod должен присутствовать синхронизированный блок по объекту lock.
•	В методе secondMethod должен присутствовать вложенный синхронизированный блок по объекту this.
•	Поле lock должно быть приватным.
•	Метод secondMethod не должен быть объявлен с модификатором synchronized.
*/
public class Main {

    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            synchronized (this) {}
            doSomething();
        }
    }

    private void doSomething() {
    }

    public static void main(String[] args) {

    }
}
