package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        int sum = 0;
        List<Character> list = new ArrayList<>();

        try{

            FileReader fileReader = new FileReader(args[0]);
            while (fileReader.ready()) {
                if (matchEnglish((char) fileReader.read()))
                sum++;
            }
            fileReader.close();


        }
        catch(Exception e){}


        System.out.println(sum);
        for (char c : list) System.out.println(c);
    }

    private static boolean matchEnglish(char c) {
        String a = Character.toString(c);
        Pattern p = Pattern.compile("^[a-zA-Z]$");
        Matcher m = p.matcher(a);
        return Pattern.matches("^[a-zA-Z]$",Character.toString(c));
    }
}
