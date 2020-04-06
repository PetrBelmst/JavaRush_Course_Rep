package com.company;

/*
Код не компилится…
Программа вводит два имени файла. И копирует первый файл на место заданное вторым именем.
Требования:
•	Программа должна считывать имена файлов.
•	Метод getInputStream изменять нельзя.
•	Метод getOutputStream изменять нельзя.
•	Программа должна копировать содержимое первого файла во второй.
•	Программа должна выводить количество скопированных байт.
•	Метод main должен вызывать метод getInputStream.
•	Метод main должен вызывать метод getOutputStream.
*/

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();
        String destinationFileName = reader.readLine();

        InputStream fileInputStream = getInputStream(sourceFileName);
        OutputStream fileOutputStream = getOutputStream(destinationFileName);

        int count = 0;
        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
            count++;
        }

        System.out.println("Скопировано байт " + count);

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}
