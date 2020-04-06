package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.
Требования:
•	Программа должна считать имена файлов с консоли.
•	Для чтения из файлов используй поток FileInputStream.
•	Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
•	Программа должна завершиться исключением DownloadException.
•	Поток FileInputStream должен быть закрыт.
*/

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fIS;

        while ((fIS = new FileInputStream(rdr.readLine())).available() > 999) {
        }
        fIS.close();
        rdr.close();

        throw new DownloadException();
    }

    public static class DownloadException extends Exception {
    }
}

