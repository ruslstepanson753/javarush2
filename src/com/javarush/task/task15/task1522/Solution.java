package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.equals(Planet.EARTH) || line.equals(Planet.SUN) || line.equals(Planet.MOON) ) {
            if (line.equals(Planet.EARTH)) {
                thePlanet = Earth.getInstance();
            }
            if(line.equals(Planet.SUN)){
                thePlanet = Sun.getInstance();
            }
            if(line.equals(Planet.MOON) ) {
                thePlanet = Moon.getInstance();
            }

        }
        else thePlanet=null;
    }
}
