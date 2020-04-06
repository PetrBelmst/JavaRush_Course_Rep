package com.company;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
Мир не меняется, меняемся мы
Разберись с ConcurrentHashMap.
В отдельном файле создайте класс Producer, который будет:
1. каждые полсекунды добавлять в ConcurrentHashMap ключ и значение, где ключ - счетчик начиная с 1,
значение - фраза: "Some text for i" , пример "Some text for 1".
2. при возникновении исключения выводить в консоль: "[THREAD_NAME] thread was terminated",
пример "[thread-1] thread was terminated".

Требования:
•	Класс Producer должен быть создан в отдельном файле.
•	Класс Producer должен реализовывать интерфейс Runnable.
•	Класс Producer должен содержать приватное поле ConcurrentHashMap<String, String> map.
•	Класс Producer должен содержать конструктор с одним параметром, инициализирующий поле map.
•	Метод run() класса Producer должен каждые полсекунды добавлять в ConcurrentHashMap ключ и
значение согласно заданию.
•	Метод run() класса Producer должен при возникновении исключения выводить в консоль "[THREAD_NAME]
thread was terminated".
*/
public class Main {

    public static void main(String[] args) throws Exception {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        Producer producer = new Producer(map);
        Consumer consumer = new Consumer(map);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(producer);
        executorService.submit(consumer);

        Thread.sleep(2000);

        executorService.shutdownNow();
        //finally 5 lines have to be printed
    }
}

