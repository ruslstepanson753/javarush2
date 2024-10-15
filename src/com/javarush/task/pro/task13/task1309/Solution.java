package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Вася Пездюков1", 4.21 );
        grades.put("Вася Пездюков2", 4.22 );
        grades.put("Вася Пездюков3", 4.23 );
        grades.put("Вася Пездюков4", 4.24 );
        grades.put("Вася Пездюков5", 4.25 );
    }
}
