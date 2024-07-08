package com.example;

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {

    private ArrayList <Card> deck;

    public DeckOfCards() {
        this.deck = new ArrayList<>();
        deck.add(new Card("green", "leaf"));
        deck.add(new Card("green", "alba"));
        deck.add(new Card("red", "ebi"));
        deck.add(new Card("red", "harm"));
        deck.add(new Card("blue","bird"));
        deck.add(new Card("blue", "plastic"));
        deck.add(new Card("purple", "spider"));
        deck.add(new Card("purple", "skele"));
        deck.add(new Card("gray", "cat"));
        deck.add(new Card("gray","acorn"));
    }

    /**
     * this method will shuffle the deck
     */
    public void shuffle(){
        Collections.shuffle(deck);
    }

    /**
     * this method will return the top of the deck.
     * if the deck is empty it will return null.
     * @return
     */
    public Card dealTopCard(){
        if (deck.size()> 0){
            return deck.remove(0);
        }else {
            return null;
        }
    }

    
}
