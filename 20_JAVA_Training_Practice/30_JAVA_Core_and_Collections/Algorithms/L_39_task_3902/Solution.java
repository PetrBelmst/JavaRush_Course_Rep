package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Биты были биты
В процессе разработки сложного алгоритма кодирования возникла задача определить четное ли
количество единиц в двоичной записи числа.

Реализуй метод boolean isWeightEven(long number), который будет возвращать true или false в
зависимости от того, является ли количество единиц в двоичном представлении числа number четным
или нечетным.

P.S. Постарайся использовать только побитовые операции, а также минимизировать время выполнения
программы.

Требования:
•	Метод isWeightEven должен возвращать true, если количество единиц в двоичном представлении анализируемого числа четное.
•	Метод isWeightEven должен возвращать false, если количество единиц в двоичном представлении анализируемого числа нечетное.
•	Время выполнения метода isWeightEven должно быть максимально близко к оптимальному.
•	Метод isWeightEven должен быть публичным и статическим.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long l = Long.parseLong(reader.readLine());
        String result = isWeightEven(l) ? "even" : "odd";
        System.out.println("The entered number has " + result + "ones");

    }

    public static boolean isWeightEven(long number) {
        int count = 0;
        while (number != 0) {
            count++;
            number = number & (number - 1);
        }
        if (count % 2 == 0) return true;
        return false;
    }
}
