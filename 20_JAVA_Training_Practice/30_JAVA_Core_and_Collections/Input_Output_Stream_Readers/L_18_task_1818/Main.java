package com.company;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;


/*
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл
содержимое третьего файла.
Закрыть потоки.
Требования:
•	Программа должна три раза считать имена файлов с консоли.
•	Для первого файла создай поток для записи. Для двух других - потоки для чтения.
•	Содержимое второго файла нужно переписать в первый файл.
•	Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
•	Созданные для файлов потоки должны быть закрыты.
*/
public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String file1, file2, file3;
        file1 = rdr.readLine();
        file2 = rdr.readLine();
        file3 = rdr.readLine();
        rdr.close();

        FileOutputStream fOSForFile1 = new FileOutputStream(file1,true);
        FileInputStream fISForFile2 = new FileInputStream(file2);
        FileInputStream fISForFile3 = new FileInputStream(file3);

        while (fISForFile2.available() > 0) {
            fOSForFile1.write(fISForFile2.read());
        }
        fISForFile2.close();

        while (fISForFile3.available() > 0) {
            fOSForFile1.write(fISForFile3.read());
        }
        fISForFile3.close();
        fOSForFile1.close();
    }
}
