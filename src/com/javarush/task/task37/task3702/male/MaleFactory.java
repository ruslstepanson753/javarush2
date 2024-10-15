package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class MaleFactory implements AbstractFactory {

    @Override
    public Human getPerson(int age) {
        Human human ;
        if (age > 19) {
            human = new Man();
        }
        else if ((age <= 19)&&(age>12)) {
            human = new TeenBoy();
        }
        else {
            human = new KidBoy();
        }
        return human;
    }
}
