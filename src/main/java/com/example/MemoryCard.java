package com.example;

public class MemoryCard extends Card{

    private boolean matched;

    public MemoryCard(String color, String name) {
        super(color, name);
        this.matched = false;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    /**
     * This method returns true if the 2 card objects
     * have same name and color
     */
    public boolean isSameCard(MemoryCard otherCard){
        return (this.getColor().equals(otherCard.getColor()) &&
                (this.getName().equals(otherCard.getName())));
    }
}
