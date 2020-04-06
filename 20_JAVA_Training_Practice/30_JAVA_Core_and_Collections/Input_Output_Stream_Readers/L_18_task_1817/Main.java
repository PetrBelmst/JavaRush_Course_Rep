package com.company;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

/*
Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.

Требования:
•	Считывать с консоли ничего не нужно.
•	Создай поток чтения из файла, который приходит первым параметром в main.
•	Посчитай отношение пробелов ко всем символам в файле и выведи в консоль это число.
•	Выведенное значение необходимо округлить до 2 знаков после запятой.
•	Поток чтения из файла должен быть закрыт.
*/
public class Main {

    public static void main(String[] args) throws Exception {

        FileInputStream fIS = new FileInputStream(args[0]);
        byte[] array = new byte[fIS.available()];
        fIS.read(array);
        fIS.close();
        double countWS = 0.00;
        String text = new String(array);
        for (Character c : text.toCharArray()) {
            if (Character.isWhitespace(c)) {
                countWS++;
            }
        }
        double size = array.length;
        double res = (countWS / size) * 100.00;

        System.out.println(new BigDecimal(res).setScale(2, RoundingMode.HALF_UP).floatValue());

    }
}
