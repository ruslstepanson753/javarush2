package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        Read3Strings t3 = new Read3Strings();

        //add your code here - добавьте код тут
        t1.start();
        t1.join();
        t2.start();
        t2.join();
//        t3.start();
//        t3.join();
        t1.printResult();
        t2.printResult();
//        t3.printResult();
    }

    public static class Read3Strings extends Thread {
        private String line = "";
        public void run() {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 3; i++) {
                line = line + " " + scanner.nextLine();
            }

        }
        public void printResult() {
            System.out.println(line);
        }
    }
}
