package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        bufferedReader.close();

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

        //defaultPrintStream = newPrintStream;

        System.setOut(defaultPrintStream); //Устанавливаем всё как было

        String result = byteArrayOutputStream.toString();
        System.out.println(result);

        try(FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            for (int i = 0;i<byteArrayOutputStream.toByteArray().length;i++){
                fileOutputStream.write(byteArrayOutputStream.toByteArray()[i]);

            }

        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

