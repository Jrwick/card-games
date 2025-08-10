package com.jwar.basiccardgames.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandardDeck {
    private final List<Card> cards;

    public StandardDeck(){
        cards = new ArrayList<>();
        populateDeck();
    }

    public List<Card> getCards() {
        return cards;
    }

    //Populates a standard 52-card deck
    private void populateDeck(){
        for (Card.Suit suit: Card.Suit.values()){
            for(int i = 1; i <=13; i++){
                cards.add(new Card(suit, i));
            }
        }
    }

    public void printShortFormDeck(){
        for (int i = 0; i < cards.size(); i++){
            System.out.print(cards.get(i).shortForm() + " ");
            if((i+1) % 13 == 0) {
                System.out.println();
            }
        }
    }

    //Prints the deck separated into suits
    //Only really used to test that all cards are populated correctly
    public void printBySuit(){
        Card.Suit currentSuit = cards.getFirst().getSuit();
        for (Card card: cards){
            if (!(card.getSuit().equals(currentSuit))){
                System.out.println();
                currentSuit = card.getSuit();
            }
            System.out.println(card);
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        return cards.size() + " cards";
    }
}
