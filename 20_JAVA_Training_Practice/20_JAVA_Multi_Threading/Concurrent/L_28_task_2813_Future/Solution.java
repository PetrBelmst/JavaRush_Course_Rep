package com.company;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
FutureTask
Класс FactorialCalculator предназначен для вычисления факториала числа переданного в его конструктор
в качестве параметра. К сожалению, он реализован некорректно и тебе необходимо это исправить.
Внимательно разбери метод main класса Solution.
Требования:
•	Класс FactorialCalculator должен поддерживать интерфейс Callable.
•	Метод call класса FactorialCalculator должен возвращать результат выполнения метода factorial.
•	Метод call класса FactorialCalculator должен быть публичным.
•	Поле number класса FactorialCalculator должно быть приватным.
*/
public class Solution {

    private static final ExecutorService threadpool = Executors.newFixedThreadPool(4);
    private static final int n = 16;

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        FactorialCalculator task = new FactorialCalculator(n);

        System.out.println("Submitting Task ...");
        Future future = threadpool.submit(task);
        System.out.println("The task was submitted successfully");

        while (!future.isDone()) {
            System.out.println("The task is not done yet....");
            Thread.sleep(1);
        }

        System.out.println("The task is done. Let's check the result");
        long factorial = (long) future.get();

        System.out.println("Factorial of " + n + " is " + factorial);
        threadpool.shutdown();
    }
}
