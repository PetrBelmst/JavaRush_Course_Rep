package com.company;

/*
Задача по алгоритмам
Задача: ввести с клавиатуры 30 чисел. Вывести 10-е и 11-е минимальные числа.
Пояснение:
Самое минимальное число - 1-е минимальное.
Следующее минимальное после него - 2-е минимальное
Пример:
1 6 5 7 1 15 63 88
Первое минимальное - 1
Второе минимальное - 1
Третье минимальное - 5
Четвертое минимальное - 6
Требования:
•	Программа должна считывать данные с клавиатуры.
•	Программа должна выводить текст на экран.
•	Класс Solution должен содержать два метода.
•	Метод sort() должен сортировать массив элементов.
•	Метод main() должен вызывать метод sort().
•	Программа должна выводить 10-е и 11-е минимальные числа. Каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        sort(array);

        for (int m : array) {
            System.out.println(m);
        }
    }

    public static void sort(int[] array) {
        Arrays.sort(array);
    }
}


/*
5
10
16
17
9
3
4
46
97
12
45
42
98
98
71
-123
-85
-16
-17
-9
-3
-4
-46
-97
 */