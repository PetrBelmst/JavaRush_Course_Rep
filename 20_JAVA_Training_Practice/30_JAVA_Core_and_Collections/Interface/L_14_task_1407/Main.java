package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Player and Dancer
1. Подумать, что делает программа.
2. Изменить метод haveFun так, чтобы он вызывал метод
- play, если person имеет тип Player.
- dance, если person имеет тип Dancer.
Требования:
•	Класс Player должен реализовывать интерфейс Person.
•	Класс Dancer должен реализовывать интерфейс Person.
•	Метод haveFun должен вызывать метод play, если переданный ему объект является игроком(Player).
•	Метод haveFun должен вызывать метод dance, если переданный ему объект является танцором(Dancer).
•	Метод main должен считывать данные с клавиатуры.
•	Метод main должен прекращать считывать данные с клавиатуры, если введенная строка равна "exit".
player
dancer
exit
*/

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Person person = null;
        String key;
        while (!(key = reader.readLine()).equals("exit")) {
            if ("player".equals(key)) {
                person = new Player();
            } else if ("dancer".equals(key)) {
                person = new Dancer();
            }
            haveFun(person);
        }
    }

    public static void haveFun(Person person) {
        //напишите тут ваш код
        if (person instanceof Player) {
            ((Player) person).play();
        } else {
            ((Dancer) person).dance();
        }
    }

    interface Person {
    }

    static class Player implements Person {
        void play() {
            System.out.println("playing");
        }
    }

    static class Dancer implements Person {
        void dance() {
            System.out.println("dancing");
        }
    }
}
