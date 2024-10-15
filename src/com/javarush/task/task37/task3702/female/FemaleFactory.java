package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;
import com.javarush.task.task37.task3702.male.KidBoy;
import com.javarush.task.task37.task3702.male.Man;
import com.javarush.task.task37.task3702.male.TeenBoy;

public class FemaleFactory implements AbstractFactory {
    @Override
    public Human getPerson(int age) {
        Human human ;
        if (age > 19) {
            human = new Woman();
        }
        else if ((age <= 19)&&(age>12)) {
            human = new TeenGirl();
        }
        else {
            human = new KidGirl();
        }
        return human;
    }


}
