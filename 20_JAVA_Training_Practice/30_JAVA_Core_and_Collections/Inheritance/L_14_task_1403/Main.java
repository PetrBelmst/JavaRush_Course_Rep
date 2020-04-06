package com.company;
/*
Building и School
1. Расставь правильно наследование между Building(здание) и School(здание школы).
2. Подумай, объект какого класса должен возвращать методы getSchool и getBuilding.
3. Измени null на объект класса Building или School.

Требования:
•	Класс School должен наследоваться от класса Building.
•	Метод getSchool должен возвращать новую школу(School).
•	Метод getBuilding должен возвращать новое здание(Building).
•	Класс School должен быть статическим.
•	Класс Building должен быть статическим.
*/

public class Main {

    public static void main(String[] args) {
        Building school = getSchool();
        Building shop = getBuilding();

        System.out.println(school);
        System.out.println(shop);
    }

    public static Building getSchool() {
        //измените null на объект класса Building или School
        return new School();
    }

    public static Building getBuilding() {
        //измените null на объект класса Building или School
        return new Building();
    }

    static class School extends Building {
        @Override
        public String toString() {
            return "School";
        }
    }

    static class Building {
        @Override
        public String toString() {
            return "Building";
        }
    }
}