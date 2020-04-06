package com.company;
/*
Producer–consumer
В классе TransferObject расставь вызовы методов wait/notify/notifyAll, чтобы обеспечить последовательное
создание и получение объекта.
В методах run классов ConsumerTask и ProducerTask создай необходимые synchronized блоки.
Ожидаемый вывод:
...
Put: M
Got: M
Put: N
Got: N
Put: K
Got: K
...
где M, N, K - числа
Метод main не участвует в тестировании
P.S. Всегда старайся использовать concurrent коллекции вместо ручной реализации wait/notify/notifyAll.
Задачи подобные этой позволяют лучше понять основы работы многопоточных приложений.
Требования:
•	В методе run класса ConsumerTask должен содержаться synchronized блок, монитор - transferObject.
•	В методе run класса ProducerTask должен содержаться synchronized блок, монитор - transferObject.
•	Метод get класса TransferObject должен ждать появления value, и возвращать его после того, как оно
появится.
•	Метод put класса TransferObject должен ждать пока value заберут и обновлять его значение после того,
как оно пропадет.
•	Метод get класса TransferObject должен устанавливать флаг isValuePresent в false и уведомлять другие
нити ожидающие освобождения монитора перед возвратом значение поля value.
•	Метод put класса TransferObject должен устанавливать флаг isValuePresent в true и уведомлять другие
нити ожидающие освобождения монитора после обновления значение поля value.
*/

public class Solution {
    public static void main(String args[]) throws InterruptedException {
        TransferObject transferObject = new TransferObject();
        ProducerTask producerTask = new ProducerTask(transferObject);
        ConsumerTask consumerTask = new ConsumerTask(transferObject);

        Thread.sleep(500);
        producerTask.stop();
        consumerTask.stop();
    }
}