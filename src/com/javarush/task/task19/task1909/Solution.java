package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String inputFileName;
        String outputFileName;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFileName = reader.readLine();
            outputFileName = reader.readLine();
        }

        try (BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(outputFileName))) {
            while (inputFileReader.ready()) {
                String line =inputFileReader.readLine().replace(".","!");
                outputFileWriter.write(line);
            }
        }

    }
}
