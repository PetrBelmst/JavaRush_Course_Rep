package com.company;

/*
Int и Integer
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
Требования:
•	Класс Solution должен содержать статический метод main().
•	Класс Solution должен содержать статический void метод print() с параметром типа int.
•	Класс Solution должен содержать статический void метод print() с параметром типа Integer.
•	Метод main() должен вызывать метод print() с параметром типа int.
•	Метод main() должен вызывать метод print() с параметром типа Integer.
*/

public class Main {

    public static void main(String[] args) {
        print(1);
        print(new Integer(3));
    }
    //Напишите тут ваши методы
    public static void print (Integer a) {}
    public static void print (int a) {}
}
