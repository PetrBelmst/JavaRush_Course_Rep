package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date receivedDate = new Date(date);
        Date startOfTheYear = new Date(date);
        startOfTheYear.setMonth(0);
        startOfTheYear.setDate(0);
        long diffInMseconds = receivedDate.getTime() - startOfTheYear.getTime();
        long msInOneDay = 24 * 60 *60 *1000;
        int daysQuantity = (int) (diffInMseconds/msInOneDay);
        return (daysQuantity % 2 != 0);
    }
}
