package com.company;

/*
Задача №6 на преобразование целых типов
Убери ненужные операторы приведения типа, чтобы получился ответ: result: 1000.0
double d = (short) 2.50256e2d;
char c = (short) 'd';
short s = (short) 2.22;
int i = (short) 150000;
float f = (short) 0.50f;
double result = f + (i / c) - (d * s) - 500e-3;
Требования:
•	Программа должна выводить текст на экран.
•	Нельзя менять команду вывода на экран.
•	Метод main() должен содержать переменную c типа char.
•	Метод main() должен содержать переменную s типа short.
•	Метод main() должен содержать переменную i типа int.
•	Метод main() должен содержать переменную f типа float.
•	Метод main() должен содержать переменную d типа double.
•	Метод main() должен содержать переменную result типа double.
•	Начальное значение переменных при инициализации менять нельзя.
Можно добавлять только операторы приведения типа.
•	Программа должна выводить текст "result: 1000.0".
*/

public class Main {

    public static void main(String[] args) {
        double d = (short) 2.50256e2d;
        char c = (short) 'd';
        short s = (short) 2.22;
        int i = 150000;
        float f = 0.50f;
        double result = f + (i / c) - (d * s) - 500e-3;

        System.out.println("result: " + result);

    }
}