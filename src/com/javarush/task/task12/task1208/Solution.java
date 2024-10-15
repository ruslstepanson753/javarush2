package com.javarush.task.task12.task1208;

/* 
Свобода печати
*/

public class Solution {
    public static void main(String[] args) {
        print(1);
        print(2,1);
        print(3,1,1);
        print(4,1,1,1);
        print(5,1,1,1,1);
    }

    public static void print(int i) {
        //System.out.println(i);
    }
    public static void print(int i, int j) {
        //System.out.println(i+j);
    }
    public static void print(int i, int j, int k) {
        //System.out.println(i+j+k);
    }
    public static void print(int i, int j, int k, int l) {
        //System.out.println(i+j+k+l);
    }
    public static void print(int i, int j, int k, int l, int m) {
        //System.out.println(i+j+k+l+m);
    }
}