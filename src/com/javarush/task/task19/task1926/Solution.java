package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
        while (bufferedReader.ready()) {
            String s = bufferedReader.readLine();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s);
            stringBuilder.reverse();
            System.out.println(stringBuilder.toString());
        }
        bufferedReader.close();
    }
}
