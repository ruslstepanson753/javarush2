package com.javarush.task.pro.task15.task1510;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/*
Пишем байты в файл
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        String path = "c:\\projects\\log.txt";// Путь к файлу.
        FileOutputStream output = new FileOutputStream(path);// Получаем объект файла: захватываем ресурс
        FileWriter writer = new FileWriter("yfgbie ");
        //output.write("хуй сука пизда");// Пишем в файл
        output.close();// Закрываем файл — освобождаем ресурс
    }
}

