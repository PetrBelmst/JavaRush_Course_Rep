package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
Работа с датами
Реализуй метод printDate(String date).
Он должен в качестве параметра принимать дату (в одном из 3х форматов) и выводить ее в консоль
в соответствии с примером:

1) Для "21.4.2014 15:56:45" вывод должен быть:
День: 21
День недели: 1
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 4
Год: 2014
AM или PM: PM
Часы: 3
Часы дня: 15
Минуты: 56
Секунды: 45

2) Для "21.4.2014":
День: 21
День недели: 1
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 4
Год: 2014

3) Для "17:33:40":
AM или PM: PM
Часы: 5
Часы дня: 17
Минуты: 33
Секунды: 40

Используй класс Calendar.

Требования:
•	Если в метод printDate передана дата в формате "дата время", он должен вывести: День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год, AM или PM, Часы, Часы дня, Минуты, Секунды.
•	Если в метод printDate передана дата в формате "дата", он должен вывести: День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год.
•	Если в метод printDate передана дата в формате "время", он должен вывести: AM или PM, Часы, Часы дня, Минуты, Секунды.
•	Используй статический метод getInstance класса Calendar для получения календаря.
*/
public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        boolean dateFlag = false;
        boolean timeFlag = false;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = null;

        if (date.contains(":")) {
            dateFormat = new SimpleDateFormat("HH:mm:ss");
            timeFlag = true;
        }

        if (date.contains(".")) {
            dateFormat = new SimpleDateFormat("dd.MM.yy");
            dateFlag = true;
        }

        if (date.contains(" ")) {
            dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
            dateFlag = true;
            timeFlag = true;
        }

        if (dateFormat == null)
            return;

        try {
            calendar.setTime(dateFormat.parse(date));
        } catch (ParseException e) {
            return;
        }

        if (dateFlag) {
            System.out.println("День: " + calendar.get(Calendar.DATE));
            System.out.println("День недели: " + ((calendar.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
        }

        if (timeFlag) {
            System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
        }
    }
}
