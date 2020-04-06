package com.company;

import java.util.Random;

/*
Замена рекурсии
В программе случайным образом генерируются два целых числа A и В в диапазоне от 0 (включая) до 1000
(не включая). Нужно вывести все целые числа от A до B включительно, в порядке возрастания, если A меньше B,
или в порядке убывания в противном случае.

Задача реализована с использованием рекурсии.
Иногда в результате работы программы получаем Exception in thread "main" java.lang.StackOverflowError.

Твоя задача: перепиши код без использования рекурсии.
Метод recursion() переименуй на getAllNumbersBetween().

Требования:
•	Метод recursion() необходимо переименовать на getAllNumbersBetween().
•	Ни в одном методе класса Solution не должно быть рекурсивных вызовов.
•	В конце строчки вывода последовательности чисел не должно быть пробела.
•	Логика работы программы должна остаться прежней.
•	Метод main() не изменять.
*/
public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder result = new StringBuilder();
        result.append(a + " ");
        if (a > b) {
            while (a != b) {
                a -= 1;
                result.append(a + " ");
            }
            return result.toString().trim();
        } else {
            if (a == b) {
                return result.toString().trim();
            }
            while (a != b) {
                a += 1;
                result.append(a + " ");
            }
            return result.toString().trim();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}