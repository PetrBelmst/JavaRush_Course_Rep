package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуй логику записи в файл и чтения из файла для карты properties.

Требования:
•	Метод fillInPropertiesMap должен считывать данные с консоли.
•	Метод fillInPropertiesMap должен создавать FileInputStream, передавая считанную строку в качестве
параметра.
•	Метод fillInPropertiesMap должен вызывать метод load передавая только что созданный FileInputStream
в качестве параметра.
•	Метод save должен сохранять карту properties в полученный в качестве параметра объект типа OutputStream.
•	Метод load должен восстанавливать состояние карты properties из полученного в качестве параметра
объекта типа InputStream.
*/
public class Main {

    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fIS = new FileInputStream(rdr.readLine());
        load(fIS);
        rdr.close();
        fIS.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, "OPS");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        properties.putAll((Map)prop);

    }

    public static void main(String[] args) {

    }
}
