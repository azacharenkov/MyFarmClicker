package com.ideas.bright.people.little.myfarmclicker.resource.upgrades;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public class Celebrity {

    private NumberFormat formatter = new DecimalFormat("+0.000");

    private String name;
    private double multiplier;
    private int level;
    private int maxLevel;
    private double chance;

    public Celebrity(String name, double multiplier, int level, int maxLevel, double chance) {
        this.name = name;
        this.multiplier = multiplier;
        this.level = level;
        this.maxLevel = maxLevel;
        this.chance = chance;
    }

    public String getName() {
        return name;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public String getMultiplierString() {
        return formatter.format(multiplier);
    }

    public int getLevel() {
        return level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public double getChance() {
        return chance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public static Celebrity getRandom(List<Celebrity> celebrities, double random) {

        double cumulativeProbability = 0.0;
        for (Celebrity celebrity : celebrities) {
            cumulativeProbability += celebrity.chance;
            if (random <= cumulativeProbability) {
                return celebrity;
            }
        }
        return null;
    }

    public static List<Celebrity> getCelebrities()
    {
        return Arrays.asList(new Celebrity("Cat-y-Pero", 0.001, 0, 10, 0.150),
                new Celebrity("B-Cardi", 0.002, 0, 10, 0.150),
                new Celebrity("Trisha P", 0.003, 0, 10, 0.150),
                new Celebrity("Shane D", 0.004, 0, 10, 0.150),
                new Celebrity("B Spears", 0.005, 0, 10, 0.125),
                new Celebrity("X-Tuna", 0.006, 0, 10, 0.125),
                new Celebrity("Cherrr", 0.007, 0, 10, 0.1),
                new Celebrity("Bim B", 0.008, 0, 10, 0.05));
    }
}
