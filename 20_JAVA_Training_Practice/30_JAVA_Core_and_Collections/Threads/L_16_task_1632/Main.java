package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.List;

/*
Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить "Ура";
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить
должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести
в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка:
Нить 4 можно проверить методом isAlive()
Требования:
•	Статический блок класса Solution должен создавать и добавлять 5 нитей в список threads.
•	Нити из списка threads не должны стартовать автоматически.
•	Нить 1 из списка threads должна бесконечно выполняться.
•	Нить 2 из списка threads должна выводить "InterruptedException" при возникновении исключения
InterruptedException.
•	Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
•	Нить 4 из списка threads должна реализовать интерфейс Message, при вызове метода
showWarning нить должна останавливаться.
•	Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N",
а потом вывести в консоль сумму введенных чисел.
 */

public class Main {

    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    System.out.println("Ура");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        @Override
        public void showWarning() {
            this.stop();
        }

        @Override
        public void run() {
            while (true) {}
        }
    }

    public static class Thread5 extends Thread {
        @Override
        public void run() {
            try {
                BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
                String s;
                int i = 0;
                while (true) {
                    s = rdr.readLine();
                    if (s.equals("N")) {
                        break;
                    } else
                        i = Integer.parseInt(s) + i;
                }
                System.out.println(i);

            } catch (Exception e) {
            }
        }

    }
}
