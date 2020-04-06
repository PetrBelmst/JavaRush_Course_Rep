package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Проверяемые исключения (checked exception)
Напиши реализацию метода veryComplexMethod().
Он должен всегда кидать какое-нибудь проверяемое исключение.
Кинуть исключение (throw) явно нельзя.

Требования:
•	Метод veryComplexMethod класса veryComplexClass не должен использовать ключевое слово throw.
•	Метод veryComplexMethod класса veryComplexClass должен бросать исключение.
•	Брошенное исключение НЕ должно быть исключением времени выполнения(RuntimeException).
•	Метод veryComplexMethod не должен быть приватным.
*/
public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        File file = new File("3");
        FileReader fileReader = new FileReader(file);
    }

    public static void main(String[] args) {

    }
}
