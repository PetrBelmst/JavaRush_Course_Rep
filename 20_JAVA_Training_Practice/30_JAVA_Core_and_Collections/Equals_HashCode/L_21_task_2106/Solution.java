package com.company;

import java.util.Date;
import java.util.Objects;

/*
Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution.
Требования:
•	Хешкоды одинаковых объектов должны быть равны.
•	Метод equals должен проверять равен ли переданный объект равен текущему (сравнение через ==).
•	Метод equals должен проверять является ли переданный объект объектом класса Solution.
•	Метод equals должен проверять значения всех полей у переданного объекта и текущего (учти что
некоторые из них могут быть равны null).
•	Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
•	В классе Solution должен быть реализован метод hashCode.
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date == null) return true;
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution == null) return true;
        if (string != null ? !string.equals(solution1.string) : solution1.string == null) return true;
        return (Objects.equals(anInt, solution1.anInt) && Objects.equals(string, solution1.string))
                && Objects.equals(aDouble, solution1.aDouble) && Objects.equals(date, solution1.date)
                && Objects.equals(solution, solution1.solution);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + anInt;
        result = 31 * result + (string == null ? 0 : string.hashCode());
        long lb = Double.doubleToLongBits(aDouble);
        result = 31 * result + (int) (lb - (lb >>> 32));
        result = 31 * result + (date == null ? 0 : date.hashCode());
        result = 31 * result + (solution == null ? 0 : solution.hashCode());
        return result;
    }

    public static void main(String[] args) {

    }
}
