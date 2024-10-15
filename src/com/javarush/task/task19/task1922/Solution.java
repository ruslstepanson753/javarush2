package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        int i = 0;
        while (bufferedReader.ready()) {
            String words1 = bufferedReader.readLine();
            String[] word = words1.split(" ");
            i = 0;
            for (String s : word) {
                for (String s2 : words) {
                    if (s.equals(s2)) {
                        i++;
                    }
                }

            }
            if (i == 2) {
                System.out.println(words1);
            }
        }
        bufferedReader.close();

    }
}


