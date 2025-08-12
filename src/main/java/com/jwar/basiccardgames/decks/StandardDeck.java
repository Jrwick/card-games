package com.jwar.basiccardgames.decks;

import com.jwar.basiccardgames.cards.Card;

public class StandardDeck extends Deck {

    public StandardDeck() {
        super();
        populateDeck();
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
}
