package com.javarush.task.pro.task17.task1703;

import java.util.ArrayList;

/* 
Космическая одиссея ч.1
*/

public class Solution {
    public static ArrayList<Astronaut> astronauts = new ArrayList<>();

    public static void main(String[] args) {
        createCrew();
        printCrewInfo();
    }

    public static void createCrew(){
        Astronaut astronaut = new Human();
        astronauts.add(astronaut);
        Astronaut astronaut2 = new Human();
        astronauts.add(astronaut2);
        Astronaut astronaut3 = new Cat();
        astronauts.add(astronaut3);
        Astronaut astronaut4 = new Dog();
        astronauts.add(astronaut4);
    }

    public static void printCrewInfo() {
        System.out.println("На борт погружены члены экипажа: ");
        for (Astronaut astronaut : astronauts) {
            System.out.println(astronaut.getInfo());
        }
    }
}
