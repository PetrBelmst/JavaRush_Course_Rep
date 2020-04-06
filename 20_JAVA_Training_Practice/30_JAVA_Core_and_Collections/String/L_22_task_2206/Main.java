package com.company;

import java.util.Date;

/*
Форматирование даты
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Должен быть вывод аналогичный следующему:
05:04:18 09:09:09 (число:месяц:год часы:минуты:секунды)
Требования:
•	Метод getFormattedString должен быть публичным.
•	Метод getFormattedString должен быть статическим.
•	Вывод на экран должен соответствовать условию задачи.
•	Метод getFormattedString должен возвращать строку с параметрами для форматирования согласно условию задачи.
*/
public class Main {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
        //должен быть вывод аналогичный следующему
        //31:10:13 15:59:59
    }

    public static String getFormattedString() {
        return "%td:%tm:%ty %tH:%tM:%tS";
    }
}
