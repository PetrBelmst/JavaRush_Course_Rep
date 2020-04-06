package com.company;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        Man nick = new Man("nick", 20, "city", "country");

        ClassLoader classLoader = nick.getClass().getClassLoader();
        Class[] interfaces = nick.getClass().getInterfaces();

        Person proxyNick = (Person) Proxy.newProxyInstance(classLoader, interfaces,
                new PersonInvocationHandler(nick));

        proxyNick.sayFrom(nick.getCity(), nick.getCountry());
    }
}
