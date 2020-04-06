package com.company;

import java.io.FileInputStream;

/*
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.
Требования:
•	Считывать с консоли ничего не нужно.
•	Создай поток чтения из файла, который приходит первым параметром в main.
•	В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
•	Нужно учитывать заглавные и строчные буквы.
•	Поток чтения из файла должен быть закрыт.
*/
public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        FileInputStream fIS = new FileInputStream(args[0]);

        int i;
        int count = 0;
        while ((i = fIS.read()) != -1) {
            if ((i >= 'a' && i <= 'z') || (i >= 'A' && i <= 'Z')) {
                count++;
            }
        }
        fIS.close();
        System.out.println(count);

    }
}
