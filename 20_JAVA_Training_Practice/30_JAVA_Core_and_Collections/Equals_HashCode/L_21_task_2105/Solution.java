package com.company;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
Исправить ошибку. Сравнение объектов
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.

Требования:
•	Хешкоды одинаковых объектов должны быть равны.
•	Метод equals должен проверять равен ли переданный объект равен текущему(сравнение через ==).
•	Метод equals должен проверять является ли переданный объект объектом класса Solution.
•	Метод equals должен возвращать true в случае, если поля first и last равны у переданного объекта и
текущего(не забудь что они могут быть равны null).
•	Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
•	В классе Solution должен быть реализован метод hashCode.
*/
public class Solution {

    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        return Objects.equals(first, n.first) &&
                Objects.equals(last, n.last);
    }

    public int hashCode() {
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}