package com.ideas.bright.people.little.myfarmclicker.resource;

public class ChickenBarn implements Barn {

    private int chickens = 0;
    private int eggs = 0;

    private double eggRate = 1;


    @Override
    public double getProduce() {
        return eggs;
    }

    @Override
    public void produce() {
        eggs += (int)  (chickens * eggRate);
    }

    @Override
    public int getAnimals() {
        return chickens;
    }

    @Override
    public double sellProduce(double price) {
        double totalPrice = price * eggs;
        eggs = 0;
        return totalPrice;
    }

    @Override
    public void addAnimals() {
        chickens += 1;
    }
}
