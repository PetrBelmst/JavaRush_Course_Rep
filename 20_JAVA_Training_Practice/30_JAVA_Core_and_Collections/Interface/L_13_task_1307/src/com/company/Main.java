package com.company;
/*
Параметризованый интерфейс
В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.
Требования:
•	Класс StringObject должен реализовывать интерфейс SimpleObject.
•	Интерфейс SimpleObject в классе StringObject должен быть реализован с параметром типа String.
•	В классе StringObject реализовать метод getInstance интерфейса SimpleObject.
•	Дополнительные классы или интерфейсы создавать нельзя.
*/

public class Main {

    public static void main(String[] args) throws Exception {
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    class StringObject implements SimpleObject<String> {

        @Override
        public SimpleObject getInstance() {
            return null;
        }
    }
}