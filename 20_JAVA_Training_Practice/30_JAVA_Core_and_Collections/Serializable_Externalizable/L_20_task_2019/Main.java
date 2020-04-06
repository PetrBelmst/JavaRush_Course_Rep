package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Исправить ошибку. Сериализация
После десериализации объекта класса Solution обнаружили, что данных в словаре [m] нет :(
Исправить 1 ошибку.
Требования:
•	В классе Solution не должно быть метода void Solution без параметров.
•	В классе Solution должен существовать конструктор без параметров.
•	В классе Solution должен существовать метод size без параметров.
•	В классе Solution метод size должен возвращать значение типа int.
*/
public class Main implements Serializable {

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("C:\\Users\\User\\Desktop\\projects_java\\practice_java_rush\\L_20_task_2019\\new_file3.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Main solution = new Main();
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //load
        FileInputStream fiStream = new FileInputStream("C:\\Users\\User\\Desktop\\projects_java\\practice_java_rush\\L_20_task_2019\\new_file3.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Main loadedObject = (Main) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    Main () {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
