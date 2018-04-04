package com.ideas.bright.people.little.myfarmclicker.resource;

public class CowBarn implements  Barn{

    private int maxCows = 100;
    private  int cows = 0;

    private double milk = 0;

    @Override
    public double getProduce() {
        return milk;
    }

    @Override
    public void produce() {
        milk = milk + Math.log(cows);
    }

    @Override
    public int getAnimals() {
        return cows;
    }

    @Override
    public double sellProduce(double price) {
        double amount = price * milk;
        milk = 0;
        return amount;
    }

    @Override
    public void addAnimals() {
        cows++;
    }
}
