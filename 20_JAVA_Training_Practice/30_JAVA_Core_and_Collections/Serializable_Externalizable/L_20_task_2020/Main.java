package com.company;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.Logger;

/*
Сериализация человека
Сериализуй класс Person стандартным способом. При необходимости добавь некоторым полям
модификатор transient.

Требования:
•	Класс Person должен поддерживать интерфейс Serializable.
•	Поле fullName должно быть отмечено модификатором transient.
•	Поле greeting должно быть отмечено модификатором transient.
•	Поле outputStream должно быть отмечено модификатором transient.
•	Поле logger должно быть отмечено модификатором transient.
•	Поле firstName НЕ должно быть отмечено модификатором transient.
•	Поле lastName НЕ должно быть отмечено модификатором transient.
•	Поле country НЕ должно быть отмечено модификатором transient.
•	Поле sex НЕ должно быть отмечено модификатором transient.
*/
public class Main {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        final transient String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {

    }
}