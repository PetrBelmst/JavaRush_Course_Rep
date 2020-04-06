package com.company;
/*
Switch для нитей
Обработай список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запусти ее.
2. Если нить в ожидании, то прерви ее.
3. Если нить работает, то проверь маркер isInterrupted.
4. Если нить прекратила работу, то выведи в консоль ее приоритет.
Используй switch.

Требования:
•	Метод processThreads принимает аргументом массив нитей.
•	Если переданная нить не запущена, нужно ее запустить.
•	Если переданная нить находится в ожидании, нужно ее прервать.
•	Если переданная нить работает, то нужно проверить маркер isInterrupted.
•	Если переданная нить завершила работу, нужно вывести в консоль ее приоритет.
•	Метод processThreads должен использовать оператор switch.
*/
public class Main {

    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread t : threads) {
            switch (t.getState()) {
                case NEW: t.start(); break;
                case BLOCKED:
                case WAITING:
                case TIMED_WAITING:
                    t.interrupt();
                    break;
                case RUNNABLE: t.isInterrupted(); break;
                case TERMINATED: System.out.println(t.getPriority()); break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
