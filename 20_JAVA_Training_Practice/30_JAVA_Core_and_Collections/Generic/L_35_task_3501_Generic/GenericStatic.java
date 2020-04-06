package com.company;

public class GenericStatic {

    public static <Number> Object someStaticMethod(Object genericObject) {
        System.out.println(genericObject);
        return genericObject;
    }
}
