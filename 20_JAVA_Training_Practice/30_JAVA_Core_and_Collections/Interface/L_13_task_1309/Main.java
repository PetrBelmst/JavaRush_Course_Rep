package com.company;
/*
Всё, что движется
1. Создай интерфейс CanMove с методом speed.
2. Метод speed должен возвращать значение типа Double и не должен ничего принимать в качестве аргументов.
3. Создай и унаследуй интерфейс CanFly от интерфейса CanMove.
4. Добавь в интерфейс CanFly метод speed.
5. Метод speed должен возвращать значение типа Double и принимать один параметр типа CanFly.

Требования:
•	В классе Solution должен быть объявлен интерфейс CanMove.
•	В классе Solution должен быть объявлен интерфейс CanFly.
•	Интерфейс CanFly должен наследоваться от интерфейса CanMove.
•	В интерфейсе CanMove должен быть объявлен метод speed без параметров и с типом возвращаемого значения Double.
•	В интерфейсе CanFly должен быть объявлен метод speed c одним аргументом типа CanFly и с типом
возвращаемого значения Double.
*/

public class Main {

    public static void main(String[] args) throws Exception {
    }

    public interface CanMove {
        public Double speed ();
    }
    public interface CanFly extends CanMove {
        Double speed(CanFly a);
    }
}






















