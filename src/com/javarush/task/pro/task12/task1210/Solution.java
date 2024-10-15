package com.javarush.task.pro.task12.task1210;

import java.util.ArrayList;

/* 
Переворачивание данных
*/

public class Solution {
    public static ArrayList <Integer> numbers= new ArrayList<Integer>();

    public static void main(String[] args) {
        init();
        print();

        reverse();
        print();
    }

    public static void init() {
        for (int i = 0; i < 10; i++) {
           numbers.add(Integer.valueOf(i)) ;
        }
    }

    public static void reverse() {
        for (int i = numbers.size() - 1; i > (numbers.size()/2-1); i--) {
            Integer temp = numbers.get(i);
            numbers.set(i, numbers.get(numbers.size()-i-1));
            numbers.set(numbers.size()-i-1, temp);
        }
    }

    private static void print() {
        for (int number=0; number < numbers.size(); number++) {
            System.out.println(numbers.get(number));
        }
    }
}
