package com.ideas.bright.people.little.myfarmclicker.resource.upgrades;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Upgrade {

    enum UpgradeType {
        BANK("$0.00/min"), QUEUE_CAPACITY("0"), CLUB_CAPACITY("0"), AUTO_CLUB("0p/min"), QUEUE_RATE("0%");

        private String extension;

        UpgradeType(String extension)
        {
            this.extension = extension;
        }

        public String getExtension(double value)
        {
            return new DecimalFormat(extension).format(value);
        }
    }

    private String name;
    private int maxLevel;
    private int level = 0;
    private double perkPerLevel;
    private UpgradeType upgradeType;
    private double price;
    private String description;

    public Upgrade(String name, int maxLevel, int level, double perkPerLevel, UpgradeType upgradeType, double price, String description) {
        this.name = name;
        this.maxLevel = maxLevel;
        this.level = level;
        this.perkPerLevel = perkPerLevel;
        this.upgradeType = upgradeType;
        this.price = price;
        this.description = description;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public int getLevel() {
        return level;
    }

    public double getPerkPerLevel() {
        return perkPerLevel;
    }

    public UpgradeType getUpgradeType() {
        return upgradeType;
    }

    public double getPrice() {
        return price;
    }

    public void incrementLevel()
    {
        this.level++;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription()
    {
        return this.description + upgradeType.getExtension(perkPerLevel);
    }

    public String getProgressText()
    {
        return "+" + upgradeType.getExtension(level * perkPerLevel);
    }

    public static List<Upgrade> createUpgrades()
    {
        List<Upgrade> upgrades = new ArrayList<>();
        upgrades.add(new Upgrade("Bigger Club", 16, 0, 150, UpgradeType.CLUB_CAPACITY, 300, "Increase club capacity by "));
        upgrades.add(new Upgrade("Extend Queue", 16, 0, 10, UpgradeType.QUEUE_CAPACITY, 50, "Increase queue capacity by "));
        upgrades.add(new Upgrade("Increase Prices", 16, 0, 0.25, UpgradeType.BANK, 300, "Increase average spend by "));
        upgrades.add(new Upgrade("Hire Bouncer", 16, 0, 15, UpgradeType.AUTO_CLUB, 500, "Attendance increased by "));
        upgrades.add(new Upgrade("Speedy Queue", 5, 0, 0.1, UpgradeType.QUEUE_RATE, 75, "Speed up the queueing by "));
        upgrades.add(new Upgrade("Even Bigger Club", 16, 0, 200, UpgradeType.CLUB_CAPACITY, 2500, "Increase club capacity by "));
        upgrades.add(new Upgrade("Light-year Queue", 5, 0, 0.15, UpgradeType.QUEUE_RATE, 2000, "Speed up the queueing by "));
        upgrades.add(new Upgrade("VIP Access", 20, 0, 20, UpgradeType.AUTO_CLUB, 3000, "Attendance increased by "));
        upgrades.add(new Upgrade("VIP Prices", 16, 0, 0.25, UpgradeType.BANK, 3500, "Increase average spend by "));

        return upgrades;
    }
}
