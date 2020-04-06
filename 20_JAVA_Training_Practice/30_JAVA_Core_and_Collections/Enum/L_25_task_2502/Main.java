package com.company;

import java.util.*;

/*
Машину на СТО не повезем!
Инициализируй поле wheels используя данные из loadWheelNamesFromDB.
Выкинь исключение в случае некорректных данных.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
Требования:
•	Enum Wheel в классе Solution менять нельзя.
•	Сигнатуры в классе Car менять нельзя.
•	Во время создания машины нужно вызвать метод loadWheelNamesFromDB.
•	В случае возврата неправильных данных о колесах, нужно кинуть исключение.
•	Инициализируй поле wheels полученными данными.
*/
public class Main {

    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
           wheels = new ArrayList<>();

           if (loadWheelNamesFromDB().length != 4) {
               throw new IllegalArgumentException();
           } else
           for (int i = 0; i < loadWheelNamesFromDB().length; i++) {
               wheels.add(Wheel.valueOf(loadWheelNamesFromDB()[i]));
           }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}