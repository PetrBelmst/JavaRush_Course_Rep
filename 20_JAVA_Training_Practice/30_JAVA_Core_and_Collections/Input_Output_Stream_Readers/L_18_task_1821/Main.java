package com.company;

import java.io.FileInputStream;

/*
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).
Пример:
','=44, 's'=115, 't'=116.
Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.
Пример вывода:
, 19
- 7
f 361
Требования:
•	Считывать с консоли ничего не нужно.
•	Создай поток для чтения из файла, который приходит первым параметром в main.
•	В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
•	Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
•	Поток для чтения из файла должен быть закрыт.
*/
public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        FileInputStream fIS = new FileInputStream(args[0]);
        int[] array = new int[256];
        while (fIS.available() > 0) {
            array[fIS.read()]++;
        }
        fIS.close();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                System.out.println((char) i + " " + array[i]);
            }
        }
    }
}
