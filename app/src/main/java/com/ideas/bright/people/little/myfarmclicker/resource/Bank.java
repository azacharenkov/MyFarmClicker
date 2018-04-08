package com.ideas.bright.people.little.myfarmclicker.resource;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Bank {

    private double balance = 0;
    private NumberFormat formatter = new DecimalFormat("$0.00");

    public double getBalance() {
        return balance;
    }

    public String toString()
    {
        return "$" + MoneyUtils.toString(balance);
    }

    public void addMoney(double money)
    {
        balance += money;
    }

    public void removeMoney(double money)
    {
        balance -= money;
    }
}
