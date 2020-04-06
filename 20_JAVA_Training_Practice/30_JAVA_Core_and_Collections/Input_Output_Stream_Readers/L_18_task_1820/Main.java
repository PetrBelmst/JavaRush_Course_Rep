package com.company;

import java.io.*;
/*
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.
Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4
Требования:
•	Программа должна два раза считать имена файлов с консоли.
•	Для первого файла создай поток для чтения. Для второго - поток для записи.
•	Считать числа из первого файла, округлить их и записать через пробел во второй.
•	Должны соблюдаться принципы округления, указанные в задании.
•	Созданные для файлов потоки должны быть закрыты.
*/
public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String file1, file2;
        file1 = rdr.readLine();
        file2 = rdr.readLine();
        rdr.close();

        BufferedReader rdr1 = new BufferedReader(new FileReader(file1));
        String line = rdr1.readLine();
        rdr1.close();
        String[] array = line.split(" ");

        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        for (int i = 0; i < array.length; i++) {
            writer.write(Math.round(Double.parseDouble(array[i])) + " ");
        }
        writer.close();
    }
}