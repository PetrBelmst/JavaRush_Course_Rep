package com.company;
/*
Как сериализовать JavaRush?
Сделай так, чтобы сериализация класса JavaRush была возможной.

Требования:
•	Класс JavaRush должен существовать внутри класса Solution.
•	Класс JavaRush должен быть статическим.
•	Класс JavaRush должен быть публичным.
•	Должна быть возможна сериализация класса JavaRush.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.Serializable;


public class Main {

    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();
    }

    public static void main(String[] args) {

    }
}
