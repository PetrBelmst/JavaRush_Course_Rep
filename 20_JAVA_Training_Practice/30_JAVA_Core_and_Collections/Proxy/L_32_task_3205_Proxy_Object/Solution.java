package com.company;

import java.lang.reflect.Proxy;

/*
Создание прокси-объекта
1) В отдельном файле создай публичный класс CustomInvocationHandler, который будет хэндлером при создании прокси-объекта.
2) CustomInvocationHandler должен поддерживать интерфейс InvocationHandler.
3) CustomInvocationHandler должен иметь один публичный конструктор с одним аргументом типа SomeInterfaceWithMethods.
4) Перед вызовом любого метода у оригинального объекта должна выводиться фраза [methodName in].
5) После вызова любого метода у оригинального объекта должна выводиться фраза [methodName out].
6) Реализуй логику метода getProxy, который должен создавать прокси (Proxy.newProxyInstance(...)).
См. пример вывода в методе main.
Метод main не участвует в тестировании.

Требования:
•	Класс CustomInvocationHandler должен существовать.
•	Класс CustomInvocationHandler должен поддерживать интерфейс InvocationHandler.
•	Класс CustomInvocationHandler должен иметь один публичный конструктор с одним аргументом типа SomeInterfaceWithMethods.
•	Перед вызовом любого метода у оригинального объекта должна выводиться фраза [methodName in].
•	После вызова любого метода у оригинального объекта должна выводиться фраза [methodName out].
•	Метод getProxy должен создавать прокси для интерфейса SomeInterfaceWithMethods.
 */
public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

    }

    public static SomeInterfaceWithMethods getProxy() {
        SomeInterfaceWithMethodsImpl obj = new SomeInterfaceWithMethodsImpl();
        ClassLoader classLoader = obj.getClass().getClassLoader();
        Class<?> [] interfecies = obj.getClass().getInterfaces();
        CustomInvocationHandler handler = new CustomInvocationHandler(obj);

        return (SomeInterfaceWithMethods) Proxy.newProxyInstance(classLoader, interfecies, handler);
    }
}
