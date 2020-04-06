package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример:
"JavaRush - лучший сервис обучения Java."
Результат:
"- лучший сервис обучения"
Пример:
"Амиго и Диего лучшие друзья!"
Результат:
"и Диего лучшие друзья!"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Требования:
•	Класс TooShortStringException должен быть потомком класса RuntimeException.
•	Метод getPartOfString должен принимать строку в качестве параметра.
•	В случае, если в метод getPartOfString были переданы некорректные данные, должно возникнуть исключение
TooShortStringException.
•	Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
*/
public class Main {

    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        Pattern p = Pattern.compile(" ");
        Matcher m = p.matcher(string);
        int counter = 0;
        String result = "";
        while (m.find()) {
            counter++;
        }
        if (counter == 4) {
            int first = string.indexOf(" ") + 1;
            result = string.substring(first);

        } else if (counter > 4) {
            String[] str = string.split(" ");
            result = str[1] + " " + str[2] + " " + str[3] + " " + str[4];
        } else throw new TooShortStringException();

        return result;
    }
    public static class TooShortStringException extends RuntimeException {
    }
}
