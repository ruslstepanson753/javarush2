package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        try (FileReader inputStream = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(inputStream)) {

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                int i = line.indexOf(" ");
                String id = line.substring(0, i);
                if (id.equals(args[0])) {
                    System.out.println(line);
                }
            }
        }


    }
}
