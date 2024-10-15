package com.javarush.task.task14.task1417;

public class Ruble extends Money{
    public String getCurrencyName() {
        return "RUB";
    }

    /*@Override
    public double getAmount() {
        return 2;
    }*/
    public Ruble(double amount) {
        super(amount);
    }
}
