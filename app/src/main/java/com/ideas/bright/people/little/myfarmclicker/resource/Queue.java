package com.ideas.bright.people.little.myfarmclicker.resource;

import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.GameMultipliers;

public class Queue {

    private int people = 20;
    private GameMultipliers gameMultipliers;

    public Queue(GameMultipliers gameMultipliers) {
        this.gameMultipliers = gameMultipliers;
    }

    public int getCapacity() {
        return gameMultipliers.getQueueCapacity();
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getPerson()
    {
        int peopleToReturn = Math.min(1, this.people);
        this.people -= Math.max(0, peopleToReturn);
        return peopleToReturn;
    }

    public void putPeople(int people)
    {
        this.people = Math.min(getCapacity(), this.people + people);
    }
}
