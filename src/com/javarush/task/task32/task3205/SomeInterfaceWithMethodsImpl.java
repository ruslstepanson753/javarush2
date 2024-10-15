package com.javarush.task.task32.task3205;

public class SomeInterfaceWithMethodsImpl implements SomeInterfaceWithMethods {
    public void voidMethodWithoutArgs() {
        System.out.println(" ");
    }

    public String stringMethodWithoutArgs() {
        System.out.println(" ");
        return null;
    }

    public void voidMethodWithIntArg(int i) {
        System.out.println(" ");
        voidMethodWithoutArgs();
    }
}
