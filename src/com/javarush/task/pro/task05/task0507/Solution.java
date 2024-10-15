package com.javarush.task.pro.task05.task0507;

import java.util.Scanner;

/* 
Максимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        array = new int[num];
        int min = 0;
        for (int i = 0; i < num; i++) {
            array[i] = scan.nextInt();
            if (i ==0) min = array[i];
            if (min < array[i]) min = array[i];
        }
        System.out.println(min);
    }
}
