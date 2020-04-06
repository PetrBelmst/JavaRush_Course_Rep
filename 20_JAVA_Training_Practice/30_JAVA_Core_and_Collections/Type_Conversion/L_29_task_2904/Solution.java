package com.company;
/*
Особенности автобоксинга
Исправь ошибку в методе getValueByIndex().
Читай доп. статью про особенности автобоксинга.

Требования:
•	Метод getValueByIndex() должен возвращать объект типа Integer из массива array, если элемент с
индексом index есть в массиве.
•	Метод getValueByIndex() должен возвращать объект типа Double, равный -1, если в массиве array
нет элемента с индексом index.
•	Метод main() не изменять.
•	Программа должна вывести две строки: "-1.0, class java.lang.Double" и "3, class java.lang.Integer".
*/

public class Solution {
    private Integer[] array = new Integer[]{1, 2, 3, 4};

    public static void main(String[] args) {
        Number value1 = new Solution().getValueByIndex(5); //-1.0, class java.lang.Double expected
        Number value2 = new Solution().getValueByIndex(2); //3, class java.lang.Integer expected

        System.out.println(value1 + ", " + value1.getClass().toString());
        System.out.println(value2 + ", " + value2.getClass().toString());
    }

    Number getValueByIndex(int index) {
        return (index >= 0 && index < array.length) ? array[index] : (Number) new Double(-1);
    }
}