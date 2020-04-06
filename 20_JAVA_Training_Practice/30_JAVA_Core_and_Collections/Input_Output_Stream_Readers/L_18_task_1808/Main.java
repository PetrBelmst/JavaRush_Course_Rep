package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/*
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.

Требования:
•	Программа должна три раза считать имена файлов с консоли.
•	Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
•	Первую половину байт из первого файла нужно записать во второй файл.
•	Вторую половину байт из первого файла нужно записать в третий файл.
•	Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rdr.readLine();
        String file2 = rdr.readLine();
        String file3 = rdr.readLine();
        rdr.close();

        FileInputStream fIS1 = new FileInputStream(file1);
        FileOutputStream fOS2 = new FileOutputStream(file2);
        FileOutputStream fOS3 = new FileOutputStream(file3);

        int size = fIS1.available();
        while (fIS1.available() > 0) {
            if (fIS1.available() > size/2) {
                fOS2.write(fIS1.read());
            } else {
                fOS3.write(fIS1.read());
            }
        }
        fIS1.close();
        fOS2.close();
        fOS3.close();
    }
}
