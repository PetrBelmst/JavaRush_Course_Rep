package com.company;

import java.util.HashMap;
import java.util.Map;

/*
Статики-1
В статическом блоке инициализировать labels 5 различными парами ключ-значение.
Требования:
•	В классе Solution должен быть только один метод (main).
•	В классе Solution должно быть объявлено статическое поле labels типа Map.
•	Поле labels должно быть заполнено 5 различными парами ключ-значение в статическом блоке.
•	Метод main должен выводить содержимое labels на экран.
*/

public class Main {

    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(2d,"q");
        labels.put(3d,"q");
        labels.put((double)4,"q");
        labels.put(5d,"q");
        labels.put(6.0,"q");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
















