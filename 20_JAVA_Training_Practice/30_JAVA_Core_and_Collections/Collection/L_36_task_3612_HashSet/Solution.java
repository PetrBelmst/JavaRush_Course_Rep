package com.company;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
Почему сет не содержит элемент?
Историки добавили несколько дат произошедших событий в уникальное множество в методе initializeDates.
Далее они точнее изучили исторические материалы, и уточнили время последнего события lastDate. Каково же
было их изумление, когда в этом множестве не находится нужная дата - метод isLastDateInDates возвращает false.
Амиго - твой долг помочь истории. Внеси необходимые изменения, чтобы дата последнего события находилась в
множестве dates (чтобы вывод программы был true).

Требования:
•	В классе Solution должно быть объявлено приватное поле Set<Date> dates.
•	В классе Solution должно быть объявлено приватное поле Date lastDate.
•	Метод isLastDateInDates должен правильно возвращать содержит ли dates дату lastDate.
•	Количество элементов в множестве dates не должно измениться после вызова метода updateLastDate.
•	В методе updateLastDate необходимо удалить из множества dates старую дату lastDate.
•	В методе updateLastDate необходимо добавить в множество dates обновленную дату lastDate.
*/
public class Solution {
    private Set<Date> dates;
    private Date lastDate;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.initializeDates();
        solution.updateLastDate(3_600_000L);
        System.out.println(solution.isLastDateInDates());
    }

    public boolean isLastDateInDates() {
        return dates.contains(lastDate);
    }

    private void initializeDates() {
        dates = new HashSet<>();
        lastDate = new Date(9999999L);
        dates.add(lastDate);
        dates.add(new Date(2222222L));
        dates.add(new Date(3333333L));
        dates.add(new Date(4444444L));
        dates.add(new Date(5555555L));
    }

    protected void updateLastDate(long delta) {
        dates.remove(lastDate);
        lastDate.setTime(lastDate.getTime() + delta);
        dates.add(lastDate);
    }
}
