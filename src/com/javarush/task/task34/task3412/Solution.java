package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Добавление логирования в класс
*/

public class Solution {
    //объявляем логгер
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        //1. заносим в логгер информацию о внесённых в конструктор переменных
        logger.debug("Constructor:\tvalue1 = " + value1 + "\tvalue2 = " + value2 + "\tvalue3 = " + value3);
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public static void main(String[] args) {

    }

    public void calculateAndSetValue3(long value) {
        // логгер отслеживания пути: сообщаем о том, что 3я переменная будет изменяеться и меняеться
        // пишем в логгер её значение до изменения
        logger.trace("calculateAndSetValue3: value = " + value);
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            // пишем в логгер изменённое значение
            logger.debug("calculateAndSetValue3: value > Integer.MAX_VALUE, value1 = " + value1);
        } else {
            value1 = (int) value;
            // пишем в логгер изменённое значение
            logger.debug("calculateAndSetValue3: value <= Integer.MAX_VALUE, value1 = " + value1);
        }
    }

    public void printString() {
        // логгер отслеживания пути: сообщаем о том, что вып-ся метод printString
        logger.trace("printString");
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        // логгер отслеживания пути: сообщаем о том, что вып-ся метод printDateAsLong
        logger.trace("printDateAsLong");
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        // логгер отслеживания пути: сообщаем о том, что вып-ся метод divide, и значения переменных до изм
        logger.trace("divide: number1 = " + number1 + ", number2 = " + number2);
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            //ловим ошибку в логгер
            // передаются: нформация о типе ош, переменные, ошибка
            logger.error("ArithmeticException: number1 = " + number1 + ", number2 = " + number2, e);
        }
    }

    public void setValue1(int value1) {
        // пишем в логгер изменённое значение
        logger.debug("setValue1: value1 = " + value1);
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        // пишем в логгер изменённое значение
        logger.debug("setValue1: value2 = " + value2);
        this.value2 = value2;
    }

    public void setValue3(Date value3) {
        // пишем в логгер изменённое значение
        logger.debug("setValue1: value3 = " + value3);
        this.value3 = value3;
    }
}
