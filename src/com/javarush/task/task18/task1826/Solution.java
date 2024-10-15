package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        switch (args[0]) {
            case "-e":
                try (FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
                     FileInputStream fileInputStream = new FileInputStream(args[1])) {
                    while (fileInputStream.available() > 0) {
                        int c = fileInputStream.read();
                        fileOutputStream.write(c - 1);
                    }
                }
                break;


            case "-d":
                try (FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
                     FileInputStream fileInputStream = new FileInputStream(args[1])) {
                    while (fileInputStream.available() > 0) {
                        int c = fileInputStream.read();
                        fileOutputStream.write(c + 1);

                    }
                    break;
                }


        }

    }
}

