package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        while (!fileName.equals("exit")) {
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
            fileName = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static class ReadThread extends Thread  {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run() {
            try {
                FileInputStream fileReader = new FileInputStream(fileName);
                int[] buf = new int[1024];
                int i = 0;
                int max = 0;
                int iminofmax = 1024;
                while (fileReader.available() > 0) {
                    i = fileReader.read();
                    if (i>=0) {
                        buf[i] ++;
                        if (buf[i] > max) {
                            max = buf[i];
                            iminofmax = i;
                        }
                        if (buf[i] == max) {
                            if (i<iminofmax)
                            {iminofmax = i;}
                        }

                    }
                }

                resultMap.put(fileName, iminofmax);

                fileReader.close();

//                for (int j = 0; j < buf.length; j++) {
//                    System.out.println(buf[j]);
//                }

            }
            catch (FileNotFoundException e) {
            }
            catch (IOException e) {
            }
        }
    }
}
