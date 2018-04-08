package com.ideas.bright.people.little.myfarmclicker.resource;

import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.GameMultipliers;

public class Club {

    private GameMultipliers gameMultipliers;
    private int people = 0;

    public Club(GameMultipliers gameMultipliers) {
        this.gameMultipliers = gameMultipliers;
    }

    public int getCapacity() {
        return gameMultipliers.getClubCapacity();
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int addPeople(int people)
    {
        int spaceLeft = getCapacity() - this.people;
        int peopleAdded = Math.min(people, spaceLeft);
        this.people += peopleAdded;
        return peopleAdded;
    }

    public void autoAttend()
    {
        addPeople(gameMultipliers.getAutoAttendance()/20);
    }

    public double getMoney()
    {
        return getPeople() * (gameMultipliers.getPricePerCustomer()/120);
    }

}
