package com.jwar.basiccardgames.players;

import com.jwar.basiccardgames.cards.Card;

import java.util.ArrayList;
import java.util.Comparator;
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

    //same as natural sort but easier to read
    public void sortHandByValueFirst(){
        hand.sort(
                Comparator.comparing(Card::getValue).thenComparing(Card::getSuit)
        );
    }

    public void sortHandBySuitFirst(){
        hand.sort(
                Comparator.comparing(Card::getSuit).thenComparing(Card::getValue)
        );
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " holding " + this.hand.size() + " cards";
    }
}
