package com.company;

public class Card {
    private Type type;
    public Card(Type t) {
        this.type = t;
    }
    public void setType(Type t) {
        this.type = t;
    }
    public Type getType() {
        return this.type;
    }
}
