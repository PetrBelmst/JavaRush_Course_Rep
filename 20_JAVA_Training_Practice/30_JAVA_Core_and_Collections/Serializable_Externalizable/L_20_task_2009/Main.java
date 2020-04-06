package com.company;

import java.io.Serializable;

/*
Как сериализовать static?
Сделай так, чтобы сериализация класса ClassWithStatic была возможной.

Требования:
•	Класс ClassWithStatic должен существовать внутри класса Solution.
•	Класс ClassWithStatic должен быть статическим.
•	Класс ClassWithStatic должен быть публичным.
•	Класс ClassWithStatic должен поддерживать интерфейс Serializable.
*/
public class Main {

    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;
    }

    public static void main(String[] args) {

    }
}

/*
Выводы:
  I) поля по отношению к сериализации делятся на две категории
     (при указании у класса implements Serializable):
     1) static и transient (которые по-умолчанию игнорируются)
     2) все остальные  (которые по-умолчанию записываются)

 II) чтобы сериализировались поля 1ой категории нужно их "вручную"
     записать/считать в методах класса writeObject/readObject(имеющих определенную
     жесткую сигнатуру) посредствам вызова методов объекта stream.

III) если в классе присутствуют методы writeObject/readObject, то поля
     из 2ой категории перестают "сами" сериализовываться.

IV) что бы восстановить свойство присущее 2ой категории
     (самостоятельно сериализовываться), можно вызвать методы
     defaultWriteObject/defaultReadObject объекта stream в методах writeObject/readObject.

V*) при деСериализации не вызывается конструктор деСериализауемого объекта

VI*) Существуют и альтернативные пути сериализации(Externalizable, JSON, XML, ...)
 */
