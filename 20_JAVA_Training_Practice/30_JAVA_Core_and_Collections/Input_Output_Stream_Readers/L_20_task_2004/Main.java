package com.company;

import java.io.*;

/*
Читаем и пишем в файл статики
Реализуй логику записи в файл и чтения из файла для класса ClassWithStatic.
Метод load должен инициализировать объект включая статические поля данными из файла.
Метод main не участвует в тестировании.

Требования:
•	Должна быть реализована возможность сохранения/загрузки объектов типа Solution.ClassWithStatic
с помощью методов save/load.
•	Класс Solution не должен поддерживать интерфейс Serializable.
•	Класс Solution.ClassWithStatic не должен поддерживать интерфейс Serializable.
•	Класс Solution.ClassWithStatic должен быть публичным.
•	Класс Solution.ClassWithStatic не должен поддерживать интерфейс Externalizable.
*/
public class Main {

    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            //File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\User\\Desktop\\projects_java\\new_file3.txt",true);
            InputStream inputStream = new FileInputStream("C:\\Users\\User\\Desktop\\projects_java\\new_file3.txt");

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();
            System.out.println(classWithStatic.getStaticString());

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;
            System.out.println(loadedObject.getStaticString());
            System.out.println(classWithStatic.getStaticString());

            loadedObject.load(inputStream);
            //here check that the classWithStatic object is equal to the loadedObject object - проверьте тут, что classWithStatic и loadedObject равны
            System.out.println(classWithStatic.equals(loadedObject));
            System.out.println(ClassWithStatic.staticString);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        public String getStaticString (){
            return this.staticString;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(this.staticString);
            writer.println(i);
            writer.println(j);
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader rdr = new BufferedReader(new InputStreamReader(inputStream));
            this.staticString = rdr.readLine();
            i = Integer.parseInt(rdr.readLine());
            j = Integer.parseInt(rdr.readLine());
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassWithStatic that = (ClassWithStatic) o;

            if (i != that.i) return false;
            return j == that.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}