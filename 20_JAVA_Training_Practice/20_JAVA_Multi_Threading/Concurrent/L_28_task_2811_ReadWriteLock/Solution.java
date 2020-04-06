package com.company;

import java.util.LinkedHashMap;

/*
ReentrantReadWriteLock
Класс ReadWriteMap должен предоставлять корректный доступ к объекту Map из многих потоков, но в его
реализации были допущены ошибки. Найди их и исправь.

P.S. Для корректной работы Map в многопоточной среде, желательно пользоваться стандартной реализацией,
например ConcurrentHashMap из пакета java.util.concurrent. Но иногда требуется работа с другим типом мапы,
например LinkedHashMap и тогда предложенное решение будет как никогда кстати.

Требования:
•	Поле readLock должно быть инициализировано с помощью метода readLock вызванного на объекте lock.
•	Поле writeLock должно быть инициализировано с помощью метода writeLock вызванного на объекте lock.
•	В методе put должен быть вызван метод lock на объекте writeLock.
•	В методе get должен быть вызван метод lock на объекте readLock.
•	В методе put в блоке finally должен быть вызван метод unlock на объекте writeLock.
•	В методе get в блоке finally должен быть вызван метод unlock на объекте readLock.
 */
public class Solution {

    public static void main(String[] args) {
        ReadWriteMap<Integer, String> linkedSafeMap = new ReadWriteMap<>(new LinkedHashMap<>());
    }
}
