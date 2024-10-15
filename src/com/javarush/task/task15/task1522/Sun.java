package com.javarush.task.task15.task1522;

public class Sun implements Planet {
    private static Sun instance ;
    public static Sun getInstance() {
        if (instance == null) {instance = new Sun();
            return instance;}
        else
            return instance;
    }
    private Sun(){

    }
}

