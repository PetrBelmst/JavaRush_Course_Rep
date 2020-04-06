package com.company;

import java.util.Random;
import java.util.Scanner;

/*
И еще раз рефакторинг
Задается целое число от 0 до 999 включительно случайным образом. Пользователь вводит с клавиатуры число.
Программа отвечает, введенное число больше или меньше загаданного. Если за 10 попыток пользователь
программы угадывает число - программа выводит:
"Ты угадал!"
"Загаданное число: [number]"
иначе "Ты проиграл!".
Исправь одну ошибку, чтобы код выполнял описанные действия.

Требования:
•	Если за 10 попыток не введено правильного числа - программа должна вывести на экран "Ты проиграл!".
•	Если введено неправильное число, флаг boolean flagWin не должен иметь значение true.
•	Не изменяй заголовки методов.
•	Нужно сделать одно изменение в правильном месте программы.
*/
public class Solution {

    public static boolean flagWin = false;

    public static void main(String[] args) {
        new Solution().runGame();
    }

    private void runGame() {
        Random random = new Random();
        int secret = random.nextInt(1000);
        int tryNumber = -1;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Попытка %d - вводи число: ", i);
            tryNumber = scanner.nextInt();
            if (tryNumber < secret)
                if (i < 10)
                    System.out.println("Загаданное число больше");
            if (tryNumber > secret)
                if (i < 10)
                    System.out.println("Загаданное число меньше");
            if (tryNumber == secret) {
                i = stopGame();
                flagWin = true;
            }
        }
        if (flagWin)
            printCongratulations(tryNumber);
        else
            printUpset();
    }

    private void printCongratulations(int number) {
        System.out.println();
        System.out.println("Ты угадал!");
        System.out.println("Загаданное число: " + number);
    }

    private void printUpset() {
        System.out.println();
        System.out.println("Ты проиграл!");
    }

    private int stopGame() {
        return 10;
    }
}