package com.company;
/*
Эй, ты там живой?
1. Создай интерфейс Person.
2. Добавь в него метод isAlive(), который проверяет, жив человек или нет.
3. Подумай, какой тип должен возвращать этот метод.
4. Создай интерфейс Presentable.
5. Унаследуй интерфейс Presentable от интерфейса Person.
Требования:
•	В классе Solution должен быть объявлен интерфейс Person.
•	В классе Solution должен быть объявлен интерфейс Presentable.
•	Интерфейс Presentable должен наследоваться от интерфейса Person.
•	В интерфейсе Person должен быть объявлен метод isAlive.
•	Тип возвращаемого значения метода isAlive может иметь только два значения.
*/

public class Main {

    public static void main(String[] args) throws Exception {
    }
    public interface Person {
        public boolean isAlive();
    }
    public interface Presentable extends Person {
    }
}