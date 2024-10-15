package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        if (a > 0) {
            int array[] = new int[a];
            for (int i = 0; i < a; i++) {
                array[i] = scan.nextInt();
            }
            if (a % 2 != 0) {
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i]);
                }
            } else {
                for (int i = array.length-1; i >= 0 ; i--) {
                    System.out.println(array[i]);
                }
            }
        }
    }
}
