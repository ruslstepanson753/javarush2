package com.javarush.task.task12.task1215;

/* 
Кошки не должны быть абстрактными!
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet {
        public  void Cat() {
            getName();
            getChild();
        }
        public  String getName(){
            return "zalupa";
        }
        public Cat getChild(){
            return new Cat();
        }


    }

    public static class Dog extends Pet {
        public  void Dog() {
            getName();
            getChild();
        }
        public  String getName(){
            return "zalupa";
        }
        public  Dog getChild(){
            return new Dog();
        }
    }

}
