package com.ideas.bright.people.little.myfarmclicker.resource.upgrades;

public class GameMultipliers {

    private double pricePerCustomer = 20.0;
    private int clubCapacity = 150;
    private int queueCapacity = 20;
    private long queueRate = 1000;
    private int autoAttendance = 0;
    private double multiplier = 1.0;

    public double getPricePerCustomer() {
        return pricePerCustomer * multiplier;
    }

    public void setPricePerCustomer(double pricePerCustomer) {
        this.pricePerCustomer = pricePerCustomer;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public void addMultiplier(double multiplier)
    {
        this.multiplier += multiplier;
    }

    public int getClubCapacity() {
        return clubCapacity;
    }

    public void setClubCapacity(int clubCapacity) {
        this.clubCapacity = clubCapacity;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public int getAutoAttendance()
    {
        return autoAttendance;
    }

    public void applyUpgrade(Upgrade upgrade)
    {
        if(upgrade.getUpgradeType() == Upgrade.UpgradeType.BANK)
        {
            this.pricePerCustomer += upgrade.getPerkPerLevel();
        } else if(upgrade.getUpgradeType() == Upgrade.UpgradeType.CLUB_CAPACITY)
        {
            this.clubCapacity += upgrade.getPerkPerLevel();
        } else if(upgrade.getUpgradeType() == Upgrade.UpgradeType.QUEUE_CAPACITY)
        {
            this.queueCapacity += upgrade.getPerkPerLevel();
        } else if(upgrade.getUpgradeType() == Upgrade.UpgradeType.QUEUE_RATE)
        {
            this.queueRate *= (1 - upgrade.getPerkPerLevel());
        } else if(upgrade.getUpgradeType() == Upgrade.UpgradeType.AUTO_CLUB)
        {
            this.autoAttendance += upgrade.getPerkPerLevel();
        }
    }

    public long getQueueRate() {
        return queueRate;
    }
}
