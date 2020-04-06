package com.company;
/*
AutoCloseable и try-with-resources
В классе FakeConnection реализуй интерфейс AutoCloseable, чтобы объекты этого типа можно было
использовать в try-with-resources.
Метод close() должен выводить на экран фразу "Closing database connection..."
В блоке try последовательно вызови методы usefulOperation() и unsupportedOperation().
Вывод на экран должен быть следующим:
Establishing database connection...
Entering body of try block.
Executing useful operation.
Operation is not supported yet!
Closing database connection...
Обрати внимание на то, что ресурсы были освобождены автоматически несмотря на исключение брошенное
методом unsupportedOperation.
Требования:
•	Класс FakeConnection должен поддерживать интерфейс AutoCloseable.
•	Метод close класса FakeConnection должен выводить на экран фразу "Closing database connection...".
•	В методе main класса Solution должны быть вызваны методы usefulOperation и unsupportedOperation
у объекта класса FakeConnection.
•	Вывод на экран должен соответствовать условию задачи.
•	Метод close класса FakeConnection не должен быть вызван явно.
 */
public class Solution {
    public static void main(String[] args) {

        DBConnectionManager dbConnectionManager = new DBConnectionManager();

        try (FakeConnection fakeConnection = dbConnectionManager.getFakeConnection())
        {
            System.out.println("Entering body of try block.");
            fakeConnection.usefulOperation();
            fakeConnection.unsupportedOperation();
        } catch (Exception e) {}
    }
}