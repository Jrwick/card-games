package cards;

import java.util.Map;
import java.util.Objects;

public class Card {

    public enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    private final Suit suit;
    private final int value;

    //Stores the string representation of the face cards.
    private static final Map<Integer, String> FACE_CARD_VALUES =
            Map.of(11, "Jack", 12, "Queen", 13, "King", 1, "Ace");

    public Card(Suit suit, int value){
        this.suit = suit;
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

    private String getFaceCard(int cardValue){
        return FACE_CARD_VALUES.get(cardValue);
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
