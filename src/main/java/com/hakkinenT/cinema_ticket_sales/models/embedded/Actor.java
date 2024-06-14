package com.hakkinenT.cinema_ticket_sales.models.embedded;

public class Actor {
    private String name;
    private Act character;

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }

    public Actor(String name, Act character) {
        this.name = name;
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Act getCharacter() {
        return character;
    }

    public void setCharacter(Act character) {
        this.character = character;
    }
}
