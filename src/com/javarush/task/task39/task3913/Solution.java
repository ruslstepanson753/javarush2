package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("src/com/javarush/task/task39/task3913/logs/"));
        Set<Object> list = new TreeSet<>();
        list = logParser.execute("get ip for user = \"Vasya Pupkin\"");
        list.forEach(System.out::println);
    }
}