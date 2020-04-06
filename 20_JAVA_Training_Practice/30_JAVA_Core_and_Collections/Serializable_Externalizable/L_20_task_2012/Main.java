package com.company;

import java.io.*;

/*
OutputToConsole
Класс OutputToConsole должен сериализовываться с помощью интерфейса Externalizable.
Найди и исправь ошибку.

Требования:
•	Класс Solution.OutputToConsole должен поддерживать интерфейс Externalizable.
•	Класс OutputToConsole должен быть создан в классе Solution.
•	Класс OutputToConsole должен быть публичным.
•	Класс OutputToConsole должен быть статическим.
*/
public class Main {

    public static String greeting = "Hello world";

    /**
     * OutputToConsole is an inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for displaying the [greeting] variable to the console.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int counter;

        /**
         * @param out A stream for externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(counter);
        }

        /**
         * @param in A stream for de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            counter = in.readInt();
        }

        /**
         * Class constructor that sets the private counter field.
         */
        public OutputToConsole(int counter) {
            this.counter = counter;
        }

        /**
         * Prints greeting message to console counter times.
         */
        public void printMessage() {
            for (int i = 0; i < counter; i++) {
                System.out.println(greeting);
            }
        }
    }

    public static void main(String[] args) {

    }
}