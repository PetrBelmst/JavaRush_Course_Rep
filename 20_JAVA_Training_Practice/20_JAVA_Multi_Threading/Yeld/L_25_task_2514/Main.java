package com.company;
/*
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
Обеспечь переуступку кванта времени (переход хода для текущей нити) для последовательных выводов текста в консоль.

Требования:
•	Класс Solution должен содержать вложенный класс YieldRunnable, который реализует интерфейс Runnable.
•	Класс YieldRunnable должен иметь поле с индексом, которое инициализируется через конструктор.
•	Метод run() должен выводить в консоль сообщения с текущим индексом о начале и конце работы метода.
•	В правильном месте должен быть вызван Thread.yield.
*/
public class Main {

    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
    }
}
