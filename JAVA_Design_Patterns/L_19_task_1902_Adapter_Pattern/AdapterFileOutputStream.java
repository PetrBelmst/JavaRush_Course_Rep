package com.company;


import java.io.FileOutputStream;
import java.io.IOException;

/*
Адаптер
Используй класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому
интерфейсу AmigoStringWriter.
Требования:
•	AmigoStringWriter должен быть интерфейсом.
•	Класс AdapterFileOutputStream должен реализовывать интерфейс AmigoStringWriter.
•	Класс AdapterFileOutputStream должен содержать приватное поле fileOutputStream типа FileOutputStream.
•	Класс AdapterFileOutputStream должен содержать конструктор с параметром FileOutputStream.
•	Метод flush() класса AdapterFileOutputStream должен делегировать полномочие такому же методу
fileOutputStream.
•	Метод writeString(String s) класса AdapterFileOutputStream должен делегировать полномочие
соответствующему методу write() объекта fileOutputStream.
•	Метод close() класса AdapterFileOutputStream должен делегировать полномочие такому же методу
fileOutputStream.
*/
public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fileOutputStream;

    AdapterFileOutputStream (FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }

    public static void main(String[] args) {

    }
}