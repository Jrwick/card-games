package com.jwar.basiccardgames.players;

import com.jwar.basiccardgames.cards.Card;
import com.jwar.basiccardgames.decks.StandardDeck;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Card> hand;
    private final String name;

    public Player (String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public List<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public void receiveCard(Card card){
        hand.add(card);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " holding " + this.hand.size() + " cards";
    }
}
