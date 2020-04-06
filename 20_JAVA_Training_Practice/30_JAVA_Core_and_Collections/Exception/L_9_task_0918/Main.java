package com.company;

/*
Все свои, даже исключения
Есть четыре класса MyException, MyException2, MyException3, MyException4.
Унаследуй классы так, чтобы у тебя появилось любые два checked исключения и любые два unchecked исключения.
Подсказка:
Изучи внимательно классы Exception1, Exception2, Exception3 из второй задачи этого блока.
Требования:
•	В классе Solution должно быть 4 вложенных класса: MyException, MyException2, MyException3 и MyException4.
•	Все вложенные классы должны быть унаследованы от классов исключений.
•	Два класса из четырех должны быть checked исключениями.
•	Два класса из четырех должны быть unchecked исключениями.
*/

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
    }

    static class MyException extends NullPointerException {
    }

    static class MyException2 extends MyException {
    }

    static class MyException3 extends IOException {
    }

    static class MyException4 extends MyException3 {
    }
}

