package com.javarush.task.pro.task11.task1104;

/* 
Конвертер строки
*/

import javax.sound.midi.Soundbank;

public class Solution {
    public static void main(String[] args) {
        String string = "12.84";
        double number = Double.parseDouble(string);
        number = Math.round(number);
        System.out.println(String.format("%.0f",number));
    }
}
