package com.company;

/*
Последовательный вывод файлов
1. Разберись, что делает программа.
2. В статическом блоке считай 2 имени файла firstFileName и secondFileName.
3. Внутри класса Solution создай нить public static ReadFileThread, которая реализует
интерфейс ReadFileInterface (Подумай, что больше подходит - Thread или Runnable).
3.1. Метод setFileName должен устанавливать имя файла, из которого будет читаться содержимое.
3.2. Метод getFileContent должен возвращать содержимое файла.
3.3. В методе run считай содержимое файла, закрой поток. Раздели пробелом строки файла.
4. Подумай, в каком месте нужно подождать окончания работы нити, чтобы обеспечить
последовательный вывод файлов.
4.1. Для этого добавь вызов соответствующего метода.
Ожидаемый вывод:
[все тело первого файла]
[все тело второго файла]
Требования:
•	Статический блок класса Solution должен считывать с консоли имена двух файлов и
сохранять их в переменные firstFileName и secondFileName.
•	Объяви в классе Solution public static класс ReadFileThread.
•	Класс ReadFileThread должен реализовывать интерфейс ReadFileInterface.
•	Класс ReadFileThread должен быть унаследован от подходящего класса.
•	Метод run класса ReadFileThread должен считывать строки из файла, установленного
методом setFileName. А метод getFileContent, этого же класса, должен возвращать вычитанный
контент. Возвращаемое значение - это одна строка, состоящая из строк файла, разделенных пробелами.
•	Метод systemOutPrintln должен вызывать метод join у созданного объекта f.
•	Вывод программы должен состоять из 2х строк. Каждая строка - содержимое одного файла.
 */

import java.io.*;

public class Main {

    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = rdr.readLine();
            secondFileName = rdr.readLine();
        } catch (IOException e) {}
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();

        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {
        void setFileName(String fullFileName);
        String getFileContent();
        void join() throws InterruptedException;
        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        public String fullFileName;
        public StringBuilder fileContent = new StringBuilder();
        public String temp;
        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }
        @Override
        public String getFileContent() {
            return fileContent.toString();
        }

        @Override
        public void run() {
            try {
                FileReader fReader = new FileReader(fullFileName);
                BufferedReader bReader = new BufferedReader(fReader);

                while ((temp = bReader.readLine()) != null) {
                    fileContent.append(temp + " ");
                } fReader.close(); bReader.close();

            } catch (Exception e) {}
        }
    }
}