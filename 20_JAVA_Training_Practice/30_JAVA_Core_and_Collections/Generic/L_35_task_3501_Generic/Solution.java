package com.company;
/*
Вызов статического метода
Измени статический метод в классе GenericStatic так, чтобы он стал дженериком.
Пример вызова дан в методе main.

Требования:
•	Метод someStaticMethod в классе GenericStatic должен быть изменен в соответствии с условием задачи.
•	Метод someStaticMethod должен быть статическим.
•	Метод someStaticMethod должен быть публичным.
•	Метод someStaticMethod должен выводить данные на экран.
*/
public class Solution {
    public static void main(String[] args) {
        Number number = (Number) GenericStatic.<Number>someStaticMethod(new Integer(3));
    }
}
