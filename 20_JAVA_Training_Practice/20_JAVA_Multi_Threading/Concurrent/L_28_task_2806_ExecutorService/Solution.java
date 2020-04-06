package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
Знакомство с Executors
1. В методе main создай фиксированный пул из 5 трэдов используя класс Executors.
2. В цикле отправь на исполнение в пул 10 задач Runnable.
3. У каждой задачи в методе run вызови метод doExpensiveOperation с порядковым номером задачи
начиная с 1, см. пример вывода.
4. Запрети добавление новых задач на исполнение в пул (метод shutdown).
5. Дай пулу 5 секунд на завершение всех задач (метод awaitTermination и параметр TimeUnit.SECONDS).

Требования:
•	Используя класс Executors, создай в методе main фиксированный пул из 5 трэдов.
•	Пул должен принимать на исполнение 10 задач Runnable.
•	Каждая задача должна вызывать метод doExpensiveOperation с порядковым номером задачи,
начиная с 1.
•	Запрети добавление новых задач на исполнение в пул.
•	На завершение всех задач в пуле нужно установить 5 секунд.
*/
public class Solution {

    public static void main(String[] args) throws InterruptedException {
        //Add your code here
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 1; i < 11; i++) {
            final int finalI = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(finalI);
                }
            });
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.SECONDS);
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}