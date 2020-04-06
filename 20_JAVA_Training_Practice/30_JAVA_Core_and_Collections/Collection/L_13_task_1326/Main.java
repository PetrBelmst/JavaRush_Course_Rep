package com.company;

import java.io.*;
import java.util.ArrayList;
import static java.util.Collections.sort;

/*
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Требования:
•	Программа должна считывать данные с консоли.
•	Программа должна создавать FileInputStream для введенной с консоли строки.
•	Программа должна выводить данные на экран.
•	Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
•	Программа должна закрывать поток чтения из файла(FileInputStream).
*/

public class Main {

    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader rdrFromConsole = new BufferedReader(new InputStreamReader(System.in));
        BufferedInputStream rdrFileInputStream = new BufferedInputStream(new FileInputStream(rdrFromConsole.readLine()));
        BufferedReader rdrFromFile = new BufferedReader(new InputStreamReader(rdrFileInputStream));

        ArrayList<Integer> numList = new ArrayList();

        while (rdrFromFile.ready()) {
            int temp = Integer.parseInt(rdrFromFile.readLine());
            if (temp % 2 == 0) {
                numList.add(temp);
            }
        }
        rdrFromFile.close();
        rdrFileInputStream.close();
        rdrFromConsole.close();

        sort(numList);
        for (Object d : numList) {
            System.out.println(d);
        }
    }
}
