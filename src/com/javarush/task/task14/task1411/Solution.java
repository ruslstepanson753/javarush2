package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        while (true){
            key = reader.readLine();
            if ( key.equals("user") ==false && key.equals("loser") ==false
                    && key.equals("coder") ==false && key.equals("proger") ==false )
            {break;}
            switch (key){
                case "user":
                    doWork(new Person.User());
                    break;
                case "coder":
                    doWork(new Person.Coder());
                    break;
                case "proger":
                    doWork(new Person.Proger());
                    break;
                case "loser" :
                    doWork(new Person.Loser());
                    break;
            }
        }

    }

    public static void doWork(Person person) {
        if(person instanceof Person.User){
            ((Person.User) person).live();
            return;
        }
        if(person instanceof Person.Coder){
            ((Person.Coder) person).writeCode();
            return;
        }
        if(person instanceof Person.Proger){
            ((Person.Proger) person).enjoy();
            return;
        }
        if (person instanceof Person.Loser){
            ((Person.Loser) person).doNothing();
            return;
        }
    }
}
