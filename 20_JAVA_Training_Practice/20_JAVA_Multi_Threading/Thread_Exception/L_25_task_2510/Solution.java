package com.company;
/*
Поживем - увидим
Все исключения, которые возникают в процессе работы нити Solution, должны быть обработаны
одним из вариантов:
1. Если это Error, то вывести в консоль "Нельзя дальше работать".
2. Если это Exception, то вывести в консоль "Надо обработать".
3. Если это Throwable, то вывести в консоль "Поживем - увидим".
Реализуй эту логику.

Требования:
•	В конструкторе Solution должен устанавливаться свой UncaughtExceptionHandler, который будет
перехватывать возникшие ошибки и выводить текст в консоль.
•	Если выполнение нити Solution закончилось исключением Error, нужно вывести в консоль "Нельзя
дальше работать".
•	Если выполнение нити Solution закончилось исключением Exception, нужно вывести в консоль "Надо
обработать".
•	Если выполнение нити Solution закончилось исключением Throwable, нужно вывести в консоль
"Поживем - увидим".
*/
public class Solution extends Thread {

    public Solution() {
        this.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Error) {
                    System.out.println("Нельзя дальше работать");
                } else if (e instanceof Exception) {
                    System.out.println("Надо обработать");
                } else if (e instanceof Throwable) {
                    System.out.println("Поживем - увидим");
                }
            }
        });
    }

    public static void main(String[] args) {
    }
}
