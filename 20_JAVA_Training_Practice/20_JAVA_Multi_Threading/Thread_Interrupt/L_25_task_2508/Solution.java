package com.company;
/*
Не валять дурака
Восстанови логику класса TaskManipulator.

Требования:
•	Класс TaskManipulator должен реализовывать интерфейсы Runnable и CustomThreadManipulator.
•	Метод run должен каждые 100 миллисекунд выводить имя исполняемой нити в консоль.
•	Класс TaskManipulator должен иметь внутреннее поле типа Thread.
•	Метод start должен создавать, сохранять во внутреннее поле и запускать нить с именем,
которое передано через аргумент метода.
•	Метод stop должен прерывать последнюю созданную классом TaskManipulator нить.
*/
public class Solution
{
    /*
     Output:
     first
     first
     second
     second
     second
     third
     fifth
     */
    public static void main(String[] args) throws InterruptedException {
        CustomThreadManipulator manipulator = new TaskManipulator();

        manipulator.start("first");
        Thread.sleep(150);
        manipulator.stop();

        manipulator.start("second");
        Thread.sleep(250);
        manipulator.stop();

        manipulator.start("third");
        Thread.sleep(50);
        manipulator.stop();

        manipulator.start("forth");
        manipulator.stop();

        manipulator.start("fifth");
        Thread.sleep(1);
        manipulator.stop();
    }
}
