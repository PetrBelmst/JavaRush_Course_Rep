package com.company;
/*
Запрети наследование
Запрети наследование от класса Listener.

Требования:
•	Класс Listener должен быть создан внутри класса Solution.
•	Класс Listener должен быть публичным.
•	Класс Listener должен быть статическим.
•	Должна быть запрещена возможность стать потомком класса Listener.
*/
public class Main {

    public static final class Listener {
        public void onMouseDown(int x, int y) {
            // Do something when the mouse down event occurs
        }

        public void onMouseUp(int x, int y) {
            // Do something when the mouse up event occurs
        }
    }

    public static void main(String[] args) {

    }
}
