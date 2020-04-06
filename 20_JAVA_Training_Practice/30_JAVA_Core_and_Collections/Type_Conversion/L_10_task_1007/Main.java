package com.company;

/*
Задача №7 на преобразование целых типов
Убери ненужные операторы приведения типа, чтобы получился ответ: 1234567
long l = (byte)1234_564_890L;
int x = (byte)0b1000_1100_1010;
double m = (byte)110_987_654_6299.123_34;
float f = (byte)l++ + 10 + ++x - (float)m;
l = (long) f / 1000;
Требования:
•	Программа должна выводить текст на экран.
•	Нельзя менять команду вывода на экран.
•	Метод main() должен содержать переменную l типа long.
•	Метод main() должен содержать переменную x типа int.
•	Метод main() должен содержать переменную m типа double.
•	Метод main() должен содержать переменную f типа float.
•	Значения переменных менять нельзя. Можно добавлять только операторы приведения типа.
•	Программа должна выводить текст 1234567.
*/

public class Main {

    public static void main(String[] args) {
        long l = 1234_564_890L;
        int x = 0b1000_1100_1010;
        double m = (byte)110_987_654_6299.123_34;
        float f = l++ + 10 + ++x - (float)m;
        l = (long) f / 1000;
        System.out.println(l);
    }
}