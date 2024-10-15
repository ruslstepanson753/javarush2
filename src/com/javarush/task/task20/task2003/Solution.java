package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        PrintWriter printWriter = new PrintWriter(outputStream);
        Properties prop = new Properties();
        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
            prop.setProperty(entry.getKey(), entry.getValue());
        }
        prop.store(printWriter, null);
        printWriter.close();
    }

    public static void load(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        Properties prop = new Properties();
        prop.load(bufferedReader);
        for (Map.Entry<Object, Object> entry : prop.entrySet()){
            runtimeStorage.put(entry.getKey().toString(), entry.getValue().toString());
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
