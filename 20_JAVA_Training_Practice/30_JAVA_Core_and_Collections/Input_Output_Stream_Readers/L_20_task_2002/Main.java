package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
Метод main реализован только для вас и не участвует в тестировании.
Требования:
•	Логика чтения/записи реализованная в методах save/load должна работать корректно в случае,
если список users пустой.
•	Логика чтения/записи реализованная в методах save/load должна работать корректно в случае,
если список users не пустой.
•	Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
•	Класс Solution.JavaRush должен быть публичным.
•	Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
*/
public class Main {

    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("C:\\Users\\User\\Desktop\\projects_java\\practice_java_rush\\L_20_task_2002", null);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\User\\Desktop\\projects_java\\practice_java_rush\\L_20_task_2002\\new_file3.txt");
            InputStream inputStream = new FileInputStream("C:\\Users\\User\\Desktop\\projects_java\\practice_java_rush\\L_20_task_2002\\new_file3.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            javaRush.save(outputStream);
            outputStream.flush();

            //JavaRush loadedObject = new JavaRush();
            //loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            for (User user : users) {
                if (user.getFirstName() != null)
                writer.println(user.getFirstName());
                writer.println(user.getLastName());
                writer.println(user.getBirthDate().getTime());
                writer.println(user.isMale());
                writer.println((user.getCountry().getDisplayName()));
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                user.setCountry(User.Country.valueOf(reader.readLine().toUpperCase()));
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
