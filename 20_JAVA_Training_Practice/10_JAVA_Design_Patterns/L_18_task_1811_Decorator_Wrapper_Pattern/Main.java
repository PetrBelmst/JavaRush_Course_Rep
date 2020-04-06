package com.company;
/*
Wrapper (Decorator)
Разберись, что делает программа.
Аналогично классу DecoratorRunnableImpl создай класс DecoratorMyRunnableImpl.

Требования:
•	Создай класс DecoratorMyRunnableImpl, аналогичный DecoratorRunnableImpl.
•	После запуска, каждый класс должен вывести в консоль "'Имя класса' body".
•	Классы RunnableImpl и DecoratorRunnableImpl изменять нельзя.
•	Метод main изменять нельзя.
*/

public class Main {

    public static void main(String[] args) {
        new Thread(new DecoratorRunnableImpl(new DecoratorMyRunnableImpl(new RunnableImpl()))).start();
    }

    public static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("RunnableImpl body");
        }
    }

    public static class DecoratorRunnableImpl implements Runnable {
        private Runnable component;
        public DecoratorRunnableImpl(Runnable component) {this.component = component;}
        @Override
        public void run() {
            System.out.print("DecoratorRunnableImpl body ");
            component.run();
        }
    }

    public static class DecoratorMyRunnableImpl implements Runnable {
        private Runnable component1;
        public DecoratorMyRunnableImpl(Runnable component) {this.component1 = component;}
        @Override
        public void run() {
            System.out.print("DecoratorMyRunnableImpl body ");
            component1.run();
        }
    }
}
