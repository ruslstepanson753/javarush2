package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.0, "A");
        labels.put(2.0, "B");
        labels.put(3.0, "C");
        labels.put(4.0, "D");
        labels.put(5.0, "E");
    }

    public static void main(String[] args) {
//       labels.put(1.1,"01 csdcv");
//        labels.put(2.2,"five and a half");
//        labels.put(3.3,"sstydfdg");
//        labels.put(4.4,"s2fdfdgg");
//        labels.put(5.5,"111bbb");
        System.out.println(labels);
    }
}
