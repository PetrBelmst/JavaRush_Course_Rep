package com.company;
/*
Какое сегодня число?
Ввести с клавиатуры дату в формате "2013-08-18"
Вывести на экран введенную дату в виде "AUG 18, 2013".
Воспользоваться объектом Date и SimpleDateFormat.
Требования:
•	Программа должна считывать данные с клавиатуры.
•	В программе должна быть объявлена переменная типа SimpleDateFormat.
•	В программе должна быть объявлена переменная типа Date.
•	Программа должна выводить данные на экран.
•	Вывод должен соответствовать заданию.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));

        Date inputDate = new Date();

        SimpleDateFormat dateFormat_input = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat_output = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

        String input = rdr.readLine();

        inputDate = dateFormat_input.parse(input);

        //System.out.println(inputDate);
        System.out.println(dateFormat_output.format(inputDate).toUpperCase());
    }
}

