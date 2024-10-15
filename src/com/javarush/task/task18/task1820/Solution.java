package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String filename1 = scan.nextLine();
        String filename2 = scan.nextLine();

        try (   FileReader fr = new FileReader(filename1);
                BufferedReader fileReader = new BufferedReader(fr);
                FileWriter fileWriter = new FileWriter(filename2)
                )
        {
            String line;
            List<String> list = new ArrayList<>();
            while (fileReader.ready()){
                line = fileReader.readLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    list.add(word);
                }

            }
            for (String word : list) {
                fileWriter.write( String.valueOf(Math.round(Double.parseDouble(word))) + " ");
            }
        }

    }
}
