package com.company;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
Сравниваем модификаторы
Реализовать логику метода isModifierSet, который проверяет, содержит ли переданный параметр
allModifiers значение конкретного модификатора specificModifier.
P.S. Перед выполнением задания ознакомься с классом Modifier и реализацией методов isPublic,
isStatic и т.п.
Требования:
•	Метод isModifierSet должен быть статическим.
•	Метод isModifierSet должен возвращать значение типа boolean.
•	Метод isModifierSet должен принимать два параметра типа int.
•	Метод isModifierSet должен возвращать корректное значение в соответствии с условием задачи
(true, если заданный модификатор присутствует в allModifiers, иначе false).
*/

public class Main {

    public static void main(String[] args) {
        int classModifiers = Main.class.getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        if ((allModifiers & specificModifier) != 0) {
            return true;
        }
        return false;
    }

    private static Method getMainMethod() {
        Method[] methods = Main.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }
        return null;
    }
}
