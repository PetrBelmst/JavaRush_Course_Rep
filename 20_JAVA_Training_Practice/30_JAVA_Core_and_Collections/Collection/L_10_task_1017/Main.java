package com.company;

/*
Безопасное извлечение из списка
Создать список целых чисел.
Ввести с клавиатуры 20 целых чисел.
Создать метод по безопасному извлечению чисел из списка:
int safeGetElement(ArrayList<Integer> list, int index, int defaultValue)
Метод должен возвращать элемент списка (list) по его индексу (index).
Если в процессе получения элемента возникло исключение, его нужно перехватить, и метод должен вернуть defaultValue.
Требования:
•	Программа должна считывать 20 чисел с клавиатуры.
•	Программа должна выводить данные на экран.
•	Метод safeGetElement должен возвращать элемент списка по индексу, если исключений внутри метода не возникло.
•	Метод safeGetElement должен возвращать defaultValue, если возникло исключений внутри метода. Исключение перехватить.
•	Метод safeGetElement не должен кидать исключения.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            int x = Integer.parseInt(reader.readLine());
            list.add(x);
        }

        System.out.println(safeGetElement(list, 5, 1));
        System.out.println(safeGetElement(list, 20, 7));
        System.out.println(safeGetElement(list, -5, 9));
    }

    public static int safeGetElement(ArrayList<Integer> list, int index, int defaultValue) {
        //напишите тут ваш код
        try {
            return list.get(index);
        } catch (IndexOutOfBoundsException e) {
            return defaultValue;
        }

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
89
12
45
98
111
42
98
98
-9
71
-150
 */