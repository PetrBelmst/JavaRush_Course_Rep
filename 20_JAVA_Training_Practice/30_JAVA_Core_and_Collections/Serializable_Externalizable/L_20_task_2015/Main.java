package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.

Hint/Подсказка:
Конструктор не вызывается при десериализации, только инициализируются все поля.

Требования:
•	Класс Solution должен поддерживать интерфейс Serializable.
•	Класс Solution должен поддерживать интерфейс Runnable.
•	Поле runner в классе Solution должно быть объявлено с модификатором transient.
•	В методе readObject должен быть создан новый объект типа Thread с текущим объектом
в качестве параметра.
•	В методе readObject должен быть вызван метод start у нового объекта типа Thread.
*/
public class Main implements Serializable, Runnable {

    private transient Thread runner;
    private int speed;

    public Main (int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
        System.out.println("ddd");
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        Thread t = new Thread(this);
        t.start();
        in.defaultReadObject();
    }

    public static void main(String[] args) {

    }
}