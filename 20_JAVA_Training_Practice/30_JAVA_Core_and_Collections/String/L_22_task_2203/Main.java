package com.company;
/*
Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.

Требования:
•	Класс TooShortStringException должен быть потомком класса Exception.
•	Метод getPartOfString должен принимать строку в качестве параметра.
•	В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций
должно возникнуть исключение TooShortStringException.
•	Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
*/
public class Main {

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.equals(null) || string.isEmpty()) {
            throw new TooShortStringException();
        }
        int temp = string.length() - string.replace("\t", "").length();
        if (temp < 2) {
            throw new TooShortStringException();
        }
        string = string.substring(string.indexOf("\t") + 1);
        string = string.substring(0, string.indexOf("\t"));
        return string;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
