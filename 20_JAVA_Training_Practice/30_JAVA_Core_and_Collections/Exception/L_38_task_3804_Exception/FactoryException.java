package com.company;

public class FactoryException extends Exception{

    public static Throwable getException (Enum e) {
        if (e == null)
            return new IllegalArgumentException();

        String message = e.name().charAt(0) + e.name().substring(1).toLowerCase().replaceAll("_", " ");

        if (e instanceof ApplicationExceptionMessage)
            return new Exception(message);

        if (e instanceof DatabaseExceptionMessage)
            return new RuntimeException(message);

        if (e instanceof UserExceptionMessage)
            return new Error(message);

        return new IllegalArgumentException();

    }
}