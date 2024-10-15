package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileThread extends Thread implements Solution.ReadFileInterface {
    private String fileName;

    public static void main(String[] args) {
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public void run() {
        super.run();
    }

    public String getFileContent() {
        String line1 = "";
        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                line1 = line1.concat(line);
                line1 = line1.concat(" ");
                line = reader.readLine();
            }
            reader.close();
            return line1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line1;

    }

}
