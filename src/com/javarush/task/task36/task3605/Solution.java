package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeSet<Character> tree= new TreeSet<>();
        while (reader.ready()) {
            Character c = (char)reader.read();
            tree.add(c);
        }
        reader.close();
        int i =0;
        for (Character c : tree) {
            if (c.charValue()>64){
                System.out.print(c);
                i++;
            }
            if (i>=5){
                break;
            }

        }
    }
}
