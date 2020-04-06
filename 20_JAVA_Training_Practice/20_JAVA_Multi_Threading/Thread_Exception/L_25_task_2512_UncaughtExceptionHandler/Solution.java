package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Живем своим умом
В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений, начиная с самого вложенного.
Пример исключения:
new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
Требования:
•	Класс Solution должен реализовывать интерфейс Thread.UncaughtExceptionHandler.
•	После вызова uncaughtException нужно прервать нить, которая бросила исключение.
•	Затем, вывести в консоль стек исключений, начиная с самого вложенного исключения.
•	Сообщения должны выводиться в формате "exception class: exception message".
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        List<Throwable> exceptionList = new ArrayList<>();
        exceptionList.add(e);

        while (exceptionList.get(exceptionList.size()-1).getCause() != null){
            exceptionList.add(exceptionList.get(exceptionList.size()-1).getCause());
        }
        Collections.reverse(exceptionList);

        for (Throwable element : exceptionList) {
            System.out.println(element.getClass().getName() + ": " + element.getMessage());
        }
    }

    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(),
                new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}