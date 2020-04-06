package com.company;
/*
Рекурсивное создание нитей
1. Измени класс GenerateThread так, чтобы он стал нитью.
2. Создай конструктор GenerateThread, который должен:
2.1. Вызвать конструктор суперкласса с параметром String - номером созданной нити. Используй createdThreadCount.
2.2. Запустить текущую нить.
2.3. Номер первой нити должен начинается с 1.
3. Переопредели метод toString, для этого внутри GenerateThread нажми Alt+Insert -> Override Methods.
Начни печатать toString.
3.1. Метод toString должен возвращать № текущей нити и слово " created". Используй getName().
Пример:
8 created
4. Пока количество созданных нитей меньше Solution.count метод run должен:
4.1. Создать новую нить типа GenerateThread.
4.2. Вывести в консоль созданную в пункте 4.1 нить.
5. В итоге должно быть выведено в консоль 15 строк.
Требования:
•	Класс GenerateThread должен быть унаследован от Thread.
•	В классе GenerateThread должен быть открытый конструктор без параметров.
•	Конструктор класса GenerateThread должен увеличивать значение createdThreadCount и передавать его
в виде строки в конструктор суперкласса.
•	Конструктор класса GenerateThread должен запускать нить.
•	Метод toString класса GenerateThread должен возвращать имя нити и слово " created". Пример: "8 created".
•	Если количество созданных нитей меньше Solution.count, метод run должен создать новую нить типа
GenerateThread.
•	Если количество созданных нитей меньше Solution.count, метод run должен вывести созданную нить в консоль.
•	Вывод программы должен соответствовать заданию, показывать, что все 15 нитей были созданы.

*/
public class Main {

    static int count = 15;
    static volatile int createdThreadCount = 0;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {
        public GenerateThread() {
            super(String.valueOf(++createdThreadCount));
            start();
        }

        @Override
        public void run() {
            if (createdThreadCount < count) {
                System.out.println(new GenerateThread());
            }
        }

        @Override
        public String toString() {
            return getName() + " created";
        }
    }
}
