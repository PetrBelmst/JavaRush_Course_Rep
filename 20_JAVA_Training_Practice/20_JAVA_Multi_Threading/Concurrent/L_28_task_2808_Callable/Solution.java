package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/*
Осваиваем Callable
Реализуй логику метода getTask, который должен возвращать объект Callable.
Объект Callable должен вычислять сумму всех чисел от 1 до переданного числа i включая его,
и возвращать его в виде строки.
Метод main не участвует в тестировании.

Требования:
•	Класс Solution должен содержать статический метод getTask(int).
•	Метод getTask должен возвращать объект Callable<String>.
•	Объект Callable должен возвращать в виде строки сумму всех чисел от 1 до переданного числа i,
включая его
•	Сумма должна правильно считаться для чисел произвольной длины.
*/
public class Solution {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1000; i <= 1010; i++) {
            futures.add(executor.submit(getTask(i)));
        }

        futures.add(executor.submit(getTask(10000000)));

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    public static Callable<String> getTask(final int i) {

        return () -> {
            BigDecimal local = new BigDecimal(0);
            for (int q = 1; q <= i; q++) {
                local = local.add(BigDecimal.valueOf(q));
            }
            return String.valueOf(local);
        };
    }
}
