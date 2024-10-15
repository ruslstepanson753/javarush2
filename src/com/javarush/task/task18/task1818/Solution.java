package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Scanner;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String fileName1 = scan.nextLine();
        String fileName2 = scan.nextLine();
        String fileName3 = scan.nextLine();

        try(
                FileWriter fileWriter1 = new FileWriter(fileName1,true);
                FileReader fileReader2 = new FileReader(fileName2);
                FileReader fileReader3 = new FileReader(fileName3)
                )
        {
            while (fileReader2.ready()){
                fileWriter1.write(fileReader2.read());
            }
            while (fileReader3.ready()){
                fileWriter1.write(fileReader3.read());
            }
        }

    }
}
