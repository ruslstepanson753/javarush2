package com.javarush.task.pro.task09.task0915;

import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String packagePath = "java.util.stream";
        String[] tokens = getTokens(packagePath, "\\.");
        System.out.println(Arrays.toString(tokens));
    }
    /*public static String[] extendArray(String[] arr, int value){

        String[] newArray = new String[arr.length + 1];

        System.arraycopy(arr, 0, newArray, 0, arr.length);

        newArray[newArray.length - 1] = value;

        return newArray;
    }*/
    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        int count = 0;
        String[] result = new String[tokenizer.countTokens()];
        while (tokenizer.hasMoreTokens()) {
            result[count] = tokenizer.nextToken();
            count++;
        }

        return result;
    }
}
