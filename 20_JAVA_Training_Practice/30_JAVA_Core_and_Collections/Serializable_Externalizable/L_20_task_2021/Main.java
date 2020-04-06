package com.company;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Сериализация под запретом
Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.
Требования:
•	Класс Solution должен поддерживать интерфейс Serializable.
•	Класс SubSolution должен быть создан внутри класса Solution.
•	Класс SubSolution должен быть потомком класса Solution.
•	При попытке сериализовать объект типа SubSolution должно возникать
исключение NotSerializableException.
•	При попытке десериализовать объект типа SubSolution должно возникать
исключение NotSerializableException.
*/
public class Main implements Serializable {

    public static class SubSolution extends Main {
        private void writeObject(ObjectOutputStream out) throws Exception {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream in) throws Exception {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
