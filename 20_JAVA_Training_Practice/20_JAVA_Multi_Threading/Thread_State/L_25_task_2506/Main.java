package com.company;
/*
Мониторинг состояния нити
Cоздай класс нити LoggingStateThread, которая будет выводить в консоль все состояния (State)
переданной в конструктор нити.
Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
Метод main не участвует в тестировании.
Требования:
•	Создай класс LoggingStateThread в отдельном файле. Он должен наследовать класс Thread.
•	Класс LoggingStateThread должен содержать поле нити, за которой он будет следить. Это поле должно
инициализироваться через конструктор.
•	Переопредели метод run в классе LoggingStateThread.
•	После запуска класс LoggingStateThread должен выводить в консоль изменения состояния переданной нити.
•	После завершения работы наблюдаемой нити, LoggingStateThread так же должен завершить работу.
*/
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start(); //NEW
        Thread.sleep(100);
        target.start();  //RUNNABLE
        Thread.sleep(100);
        //TERMINATED
    }
}