package com.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/*
Добавление логирования в класс
В Intellij IDEA Alt+Ctrl+Shift+S -> Global Libraries -> New Global Library -> From Maven...
В строке поиска в открывшемся окне укажи: org.slf4j:slf4j-api:1.7.23 -> Поиск (Shift+Enter)
Укажи куда скачать библиотеку логирования.
Выбрери к какому модулю проекта подключить библиотеку slf4j-api: нужно выбрать
4.JavaCollections -> OK
Apply -> OK.
Посмотри где бы ты в классе Solution применил какой уровень логирования?
В класс Solution нужно добавить вызовы методов уровня:
error - 1 раз;
debug - 6 раз - используй при изменениях значений полей класса;
trace - 4 раза - используй для отслеживания пути выполнения програмы;
Сообщения в логах старайся писать информативные.
Остальной код не изменяй.

Требования:
•	В классе Solution должно существовать приватное статическое финальное поле logger.
•	Добавь логирование уровня error один раз.
•	Добавь логирование уровня debug шесть раз.
•	Добавь логирование уровня trace четыре раза.
*/
public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        logger.debug("constructor" + this.value1 + this.value2 + this.value3);
    }

    public static void main(String[] args) {

    }

    public void calculateAndSetValue3(long value) {
        logger.trace("calculateAndSetValue3");
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("value1 " + value1);
        } else {
            value1 = (int) value;
            logger.debug("value1 " + value1);
        }
    }

    public void printString() {
        logger.trace("printString");
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("printDateAsLong");
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        logger.trace("divide");
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("error in method divide" + e);
        }
    }

    public void setValue1(int value1) {
        this.value1 = value1;
        logger.debug("setValue1 method - value1: " + this.value1);
    }

    public void setValue2(String value2) {
        this.value2 = value2;
        logger.debug("setValue2 method - value2: " + this.value2);
    }

    public void setValue3(Date value3) {
        this.value3 = value3;
        logger.debug("setValue3 method - value3: " + this.value3);
    }
}