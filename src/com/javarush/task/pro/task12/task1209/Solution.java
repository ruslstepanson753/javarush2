package com.javarush.task.pro.task12.task1209;

import java.util.ArrayList;
import java.util.Scanner;

/* 
Бухгалтерия
*/

public class Solution {
    public static ArrayList<String> waitingEmployees = new ArrayList<>();
    public static ArrayList<String> alreadyGotSalaryEmployees = new ArrayList<>();

    public static void initEmployees() {
        waitingEmployees.add("Гвинно");
        waitingEmployees.add("Гунигерд");
        waitingEmployees.add("Боргелейф");
        waitingEmployees.add("Нифрод");
        waitingEmployees.add("Альбиуф");
        waitingEmployees.add("Иногрим");
        waitingEmployees.add("Фриле");
        //waitingEmployees.add("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initEmployees();
        paySalary(scanner.nextLine());
        for (int i = 0; i < waitingEmployees.size(); i++) {System.out.println(waitingEmployees.get(i));}



    }

    public static void paySalary(String name) {
        if (!waitingEmployees.contains(name)) { return;}
        if (name=="null") {return;}
        alreadyGotSalaryEmployees.add(name);
        waitingEmployees.set(waitingEmployees.indexOf(name), null);

    }


}

