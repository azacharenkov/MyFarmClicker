package com.ideas.bright.people.little.myfarmclicker.resource;

public class Club {

    private int capacity = 100;
    private int people = 0;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public void addPeople(int people)
    {
        this.people += people;
    }
}
