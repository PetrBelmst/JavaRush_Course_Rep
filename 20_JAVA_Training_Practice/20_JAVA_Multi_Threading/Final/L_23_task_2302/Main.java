package com.company;
/*
Запрети переопределение
Запрети переопределение метода onMouseDown.

Требования:
•	Класс Listener должен быть создан внутри класса Solution.
•	Класс Listener должен быть публичным.
•	Метод onMouseDown должен быть публичным.
•	Должна быть запрещена возможность переопределить метод onMouseDown.
*/
public class Main {

    public static class Listener {
        public final void onMouseDown(int x, int y) {
            // Do something when the mouse down event occurs
        }

        public void onMouseUp(int x, int y) {
            // Do something when the mouse up event occurs
        }
    }

    public static void main(String[] args) {

    }
}
