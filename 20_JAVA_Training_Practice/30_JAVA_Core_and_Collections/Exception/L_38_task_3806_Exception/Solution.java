package com.company;

/*
Улучшения в Java 7 (try-with-resources)
Перепиши реализации методов класса Solution.
Используй нововведения (try-with-resources), касающиеся обработки исключений, которые
были добавлены в Java 7.

Требования:
•	В методе printFile1 не должно быть catch блоков.
•	В методе printFile2 не должно быть catch блоков.
•	В методе printFile1 FileInputStream должен быть инициализирован как ресурс в блоке try.
•	В методе printFile2 BufferedInputStream должен быть инициализирован как ресурс в блоке try.
•	В методе printFile2 FileInputStream должен быть инициализирован как ресурс в блоке try.
•	В методе printFile2 должен быть только один блок try.
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public void printFile1() throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream("file.txt"))
        {
            int data = fileInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = fileInputStream.read();
            }
        } finally {}
    }

    public void printFile2() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("file.txt");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream))
        {
            int data = bufferedInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = bufferedInputStream.read();
            }
        } finally {}
    }

    public static void main(String[] args) {

    }
}
