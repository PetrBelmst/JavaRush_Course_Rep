package com.company;

import java.io.*;

/*
Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
Требования:
•	Программа должна считывать c консоли имя файла.
•	Программа должна выводить на экран содержимое файла.
•	Поток чтения из файла (FileInputStream) должен быть закрыт.
•	BufferedReader также должен быть закрыт.
*/

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rdr.readLine();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));

        while (bis.available() > 0) {
            char c = (char) bis.read();
            System.out.print(c);
        }
        rdr.close();
        bis.close();
    }
}