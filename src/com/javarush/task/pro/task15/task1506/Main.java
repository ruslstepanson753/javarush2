package com.javarush.task.pro.task15.task1506;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.List;

public class Main  {

    public static void main(String[] args) throws Exception {

        Path testFilePath = Paths.get("C:\\Users\\Rusl\\Desktop\\testFile.txt.txt");
        //List<String> lines = Files.readAllLines(testFilePath);
        File file = new File(
                "C:\\Users\\Rusl\\Desktop\\testFile.txt.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        /*
        Path fileName = testFilePath.getFileName();
        System.out.println(fileName);

        Path parent = testFilePath.getParent();
        System.out.println(parent);

        Path root = testFilePath.getRoot();
        System.out.println(root);

        boolean endWithTxt = testFilePath.endsWith("Desktop\\testFile.txt");
        System.out.println(endWithTxt);

        boolean startsWithLalala = testFilePath.startsWith("lalalala");
        System.out.println(startsWithLalala);*/
    }
}


