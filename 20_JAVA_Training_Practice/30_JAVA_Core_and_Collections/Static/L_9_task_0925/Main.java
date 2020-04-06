package com.company;

/*
Статики не на своем месте
Расставь модификаторы static так, чтобы пример скомпилировался.
Требования:
•	В классе должна быть переменная A.
•	В классе должна быть переменная B.
•	В классе должна быть переменная C.
•	Метод main не изменять.
•	Метод getA не изменять.
•	В классе должно быть 3 статических поля.
*/

public class Main {

    public static int A = 5;
    public static int B = 2 * A;
    public int C = A * B;
    public static int D = A * B;

    public static void main(String[] args) {
        Main room = new Main();
        room.A = 5;
        Main.D = 5;
    }

    public int getA() {
        return A;
    }

}
