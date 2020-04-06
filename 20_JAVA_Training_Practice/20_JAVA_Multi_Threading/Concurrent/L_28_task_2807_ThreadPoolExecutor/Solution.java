package com.company;

import java.util.concurrent.*;

/*
Знакомство с ThreadPoolExecutor
1. В методе main создай очередь LinkedBlockingQueue<Runnable>.
2. В цикле добавь в очередь 10 задач Runnable.
3. У каждой задачи в методе run вызови метод doExpensiveOperation с порядковым номером
задачи начиная с 1, см. пример вывода.
4. Создай объект ThreadPoolExecutor со следующими параметрами:
- основное количество трэдов (ядро) = 3,
- максимальное количество трэдов = 5,
- время удержания трэда живым после завершения работы = 1000,
- тайм-юнит - миллисекунды,
- созданная в п.1. очередь с задачами.
5. Запусти все трэды, которые входят в основное кол-во трэдов - ядро, используй метод
prestartAllCoreThreads.
6. Запрети добавление новых задач на исполнение в пул (метод shutdown).
7. Дай объекту ThreadPoolExecutor 5 секунд на завершение всех тасок
(метод awaitTermination и параметр TimeUnit.SECONDS).
Требования:
•	В методе main нужно создать очередь LinkedBlockingQueue<Runnable>.
•	В цикле добавь в очередь 10 задач Runnable.
•	Нужно создать объект ThreadPoolExecutor с параметрами, указанными в задании.
•	С помощью метода prestartAllCoreThreads нужно запустить основные трэды.
•	Каждая задача должна вызывать метод doExpensiveOperation с порядковым номером задачи,
начиная с 1.
•	Запрети добавление новых задач на исполнение в пул.
•	На завершение всех задач в пуле нужно установить 5 секунд.
*/
public class Solution {

    public static void main(String[] args) throws InterruptedException {
        // Add your code here
        LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>();
        for (int i = 1; i < 11; i++) {
            final int localID = i;
            runnables.add(() -> doExpensiveOperation(localID));
        }

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,
                5, 1000, TimeUnit.MILLISECONDS, runnables);

        executor.prestartAllCoreThreads();
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
