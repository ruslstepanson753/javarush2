package com.javarush.task.pro.task05.task0519;

import java.util.Arrays;

/* 
Есть ли кто?
*/

public class Solution {

    public static int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static int element = 5;

    public static void main(String[] args) {
        int [] array1 = Arrays.copyOf(array, array.length);
        Arrays.sort(array1);
        int index = Arrays.binarySearch(array1,element);
        System.out.println(index>=0);
    }
}
