package com.company;
/*
Напряги извилины!
Метод printName должен выводить имя собственного объекта, т.е. "The Darkside Hacker"
Сделайте минимум изменений.
Требования:
•	Вывод на экран должен соответствовать условию.
•	В классе Solution должен присутствовать метод sout без параметров.
•	В классе Solution должно присутствовать поле name.
•	Модификатор доступа метода getName должен быть расширен.
*/
public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void sout() {
        new Solution("The Darkside Hacker") {
            void printName() {
                System.out.println(this.getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("Риша").sout();
    }
}
