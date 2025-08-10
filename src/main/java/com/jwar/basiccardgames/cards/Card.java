package com.jwar.basiccardgames.cards;

import java.util.Map;
import java.util.Objects;

public class Card {

    public enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    public enum Colour {
        BLACK,
        RED
    }

    private final Suit suit;
    //Should I use enum for value too?
    private final int value;
    private final Colour colour;

    //Stores the string representation of the face cards.
    private static final Map<Integer, String> FACE_CARD_VALUES =
            Map.of(11, "Jack", 12, "Queen", 13, "King", 1, "Ace");

    public Card(Suit suit, int value){
        this.suit = suit;

        if (suit.equals(Suit.CLUBS) || suit.equals(Suit.SPADES)){
            this.colour = Colour.BLACK;
        } else {
            this.colour = Colour.RED;
        }

        if (value > 0 && value <= 13){
            this.value = value;
        } else {
            throw new IllegalArgumentException("Value should be between 1 and 13");
        }
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public Colour getColour() {
        return colour;
    }

    private String getFaceCard(int cardValue){
        return FACE_CARD_VALUES.get(cardValue);
    }

    //returns the string reprensation of a card in short form in the format
    //VS where V is the value of the card and S is the initial card suit.
    public String shortForm(){
        String str;
        if (this.value > 1 && this.value <=10){
            str = String.valueOf(getValue());
        } else {
            str = String.valueOf(getFaceCard(getValue()).charAt(0));
        }
        return str + suit.toString().charAt(0);
    }


    @Override
    public String toString() {
        String str;
        if (this.value > 1 && this.value <=10){
            str = String.valueOf(getValue());
        } else {
            str = getFaceCard(getValue());
        }
        return str + " of " + suit.toString().toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Card card)) return false;
        return getValue() == card.getValue() && getSuit() == card.getSuit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuit(), getValue());
    }
}
