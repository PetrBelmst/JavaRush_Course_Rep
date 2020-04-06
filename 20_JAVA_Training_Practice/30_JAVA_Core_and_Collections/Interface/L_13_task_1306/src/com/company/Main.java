package com.company;
/*
Баг в initializeIdAndName
1. Подумать, что в программе неправильно.
2. Вынести реализацию метода initializeIdAndName в класс User.
3. initializeIdAndName в классе User должен возвращать тип User.
4. Поправить программу, чтобы компилировалась и работала.

Требования:
•	Интерфейс DBObject должен содержать только объявление метода initializeIdAndName без реализации.
•	Реализуй метод initializeIdAndName в классе User.
•	Метод initializeIdAndName в классе User должен иметь тип возвращаемого значения User.
•	Метод initializeIdAndName должен присваивать значения полям id и name объекта типа User в
соответствии с переданными ему параметрами и возвращать этот объект.
*/

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(Matrix.NEO);
        System.out.println(Matrix.TRINITY);
    }

    static class Matrix {
        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
        public static DBObject TRINITY = new User().initializeIdAndName(2, "Trinity");
    }

    interface DBObject {
        public DBObject initializeIdAndName(long id, String name);
    }

    static class User implements DBObject {
        long id;
        String name;

        @Override
        public User initializeIdAndName(long id, String name) {
            this.id = id;
            this.name = name;
            return this;
        }

        @Override
        public String toString() {
            return String.format("The user's name is %s, id = %d", name, id);
        }
    }
}