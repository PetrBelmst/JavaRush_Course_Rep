package com.company;
/*
Свой enum
Реализуй интерфейс Columnable у Column, описание методов смотрите в джавадоках.
Реализуй логику метода Column.getVisibleColumns.
Метод Column.configureColumns уже реализован, его не меняй.
Создавать дополнительные поля нельзя.
Метод main не участвует в тестировании.
Требования:
•	Интерфейс Columnable менять нельзя.
•	Класс Column должен реализовывать интерфейс Columnable.
•	Создавать дополнительные поля в классе Column нельзя.
•	Метод Column.configureColumns реализован. Менять его не нужно.
•	Метод Column.getVisibleColumns должен возвращать список отображаемых колонок
в скофигурированом порядке.
•	Метод Column.getColumnName должен возвращать полное имя колонки.
•	Метод Column.isShown должен возвращать true, если колонка видимая, иначе false.
•	Метод Column.hide должен скрывать колонку и сдвигать индексы остальных отображаемых колонок.
*/
public class Solution {
    /**
     * Output:
     * <p/>
     * Available Amount
     * Account Number
     * Bank Name
     * --------------------
     * Available Amount
     * Bank Name
     */
    public static void main(String[] args) {

        Column.configureColumns(Column.Amount, Column.AccountNumber, Column.BankName);

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }

        System.out.println("--------------------");
        Column.AccountNumber.hide();

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }
    }
}