package com.javarush.task.pro.task03.task0306;

import java.util.Scanner;

/* 
Треугольник
*/

public class Solution {
    private static final String TRIANGLE_EXISTS = "треугольник существует";
    private static final String TRIANGLE_NOT_EXISTS = "треугольник не существует";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        if (a >= (b + c)) System.out.printf(TRIANGLE_NOT_EXISTS);
        if (b >= (a + c)) System.out.printf(TRIANGLE_NOT_EXISTS);
        if (c >= (b + a)) System.out.printf(TRIANGLE_NOT_EXISTS);
        if ((a < (b + c)) && (b < (a + c)) && (c < (b + a))) System.out.printf(TRIANGLE_EXISTS);


    }
}
