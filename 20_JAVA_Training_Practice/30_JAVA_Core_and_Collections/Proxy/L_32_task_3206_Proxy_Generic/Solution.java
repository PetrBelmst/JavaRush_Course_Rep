package com.company;

import java.lang.reflect.Proxy;

/*
Дженерики для создания прокси-объекта
В классе Solution создай публичный метод getProxy:
1) Метод getProxy должен возвращать прокси для любого интерфейса, который наследуется от Item.
2) getProxy должен иметь два параметра. Первый - класс возвращаемого типа, второй - классы дополнительных
интерфейсов (используй аргумент переменной длины ...).
3) Используй ItemInvocationHandler для создания прокси.
Метод main не участвует в тестировании.

Требования:
•	В классе Solution должен существовать метод getProxy.
•	Метод getProxy должен иметь два параметра. Первый - класс возвращаемого типа, второй - классы дополнительных
интерфейсов.
•	Метод getProxy должен возвращать прокси для любого интерфейса, который наследуется от Item.
•	В методе getProxy при вызове Proxy.newProxyInstance передай this.getClass().getClassLoader() в качестве
первого аргумента.
•	В методе getProxy при вызове Proxy.newProxyInstance передай вторым аргументом все интерфейсы, которые
прокси должен реализовать.
•	В методе getProxy при вызове Proxy.newProxyInstance передай new ItemInvocationHandler() как третий аргумент.
•	Метод getProxy должен работать согласно с условием.
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }

    public <T extends Item> T getProxy(Class<T> clazz, Class... interf) {
        Class<?>[] interfaces = new Class[interf.length + 1];
        interfaces[0] = clazz;
        System.arraycopy(interf, 0, interfaces, 1, interf.length);

        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                interfaces, new ItemInvocationHandler());
    }

    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
}