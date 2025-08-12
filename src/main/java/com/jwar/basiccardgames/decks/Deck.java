package com.jwar.basiccardgames.decks;

import com.jwar.basiccardgames.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Deck {
    protected final List<Card> cards;

    public Deck(){
        cards = new ArrayList<>(52);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    //No validation here, what if the deck is empty
    public Card dealTopCard(){
        return cards.removeLast();
    }

    @Override
    public String toString() {
        return cards.size() + " cards";
    }
}
