package com.javarush.task.task14.task1417;

public class USD extends Money{
    public String getCurrencyName() {
        return "USD";
    }

//    @Override
//    public double getAmount() {
//        return 1;
//    }
    public USD(double amount) {
        super(amount);
    }
}
