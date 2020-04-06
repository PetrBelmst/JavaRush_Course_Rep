package com.company;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Serializable Solution
Сериализуй класс Solution.
Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution - savedObject;
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solution с другим параметром;
5) загрузить из потока на чтение объект - loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.
Требования:
•	Поле pattern должно быть отмечено модификатором transient.
•	Поле currentDate должно быть отмечено модификатором transient.
•	Поле temperature должно быть отмечено модификатором transient.
•	Поле string НЕ должно быть отмечено модификатором transient.
*/
public class Main implements Externalizable {

    public static void main(String[] args) {
        System.out.println(new Main(4));
        try {
            InputStream fIS = new FileInputStream("C:\\Users\\User\\Desktop\\projects_java\\new_file3.txt");
            OutputStream fOS = new FileOutputStream("C:\\Users\\User\\Desktop\\projects_java\\new_file3.txt");

            Main savedObject = new Main(5);
            savedObject.writeExternal((ObjectOutput) fOS);
            Main loadedObject = new Main(7);
            loadedObject.readExternal((ObjectInput) fOS);
            System.out.println(savedObject.equals(loadedObject));


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("fff");
        }
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Main(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(string);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        string = (String) in.readObject();


    }
}