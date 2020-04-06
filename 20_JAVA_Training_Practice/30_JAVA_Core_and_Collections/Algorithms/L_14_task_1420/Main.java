package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.

Требования:
•	Программа должна считывать с клавиатуры 2 строки.
•	В случае если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
•	Программа должна выводить данные на экран.
•	Программа должна выводить на экран наибольший общий делитель(НОД) чисел считанных с клавиатуры и успешно завершаться.
*/

public class Main {

        public static void main(String[] args) throws Exception {

                BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
                int a = Integer.parseInt(rdr.readLine());

                if (a <= 0) {
                        throw new Exception();
                }

                int b = Integer.parseInt(rdr.readLine());

                if (b <= 0) {
                        throw new Exception();
                }

                rdr.close();
                int c = a % b;

                while (c != 0) {
                        a = b;
                        b = c;
                        c = a % b;
                }

                System.out.println(b);
        }
}