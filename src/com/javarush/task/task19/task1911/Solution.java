package com.javarush.task.task19.task1911;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //Общее назначение класса PrintStream — вывод информации в какой-то поток.
        // System.out является объектом PrintStream
        PrintStream defaultPrintStream = System.out;//запоминаем настоящий PrintStream в специальную переменную

        //Поток класса ByteArrayOutputStream создает буфер в памяти,
        // и все данные, отправленные в поток, хранятся в буфере.
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); //Создаем динамический массив

        PrintStream newPrintStream = new PrintStream(byteArrayOutputStream);//создаем адаптер к классу PrintStream

        System.setOut(newPrintStream); //Устанавливаем его как текущий System.out

        testString.printSomething(); //Вызываем функцию, которая ничего не знает о наших манипуляциях
        // в этот момент печать идёт в буфер, т.к. мы его подменили вместо defaultPrintStream

        System.setOut(defaultPrintStream); //Устанавливаем всё как было

        String result = byteArrayOutputStream.toString().toUpperCase();// берём данные из буфера

        System.out.println(result);// данные по дефолту выводятся в консоль
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

