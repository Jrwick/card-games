package com.jwar.basiccardgames.games;

import com.jwar.basiccardgames.cards.Card;
import com.jwar.basiccardgames.decks.StandardDeck;
import com.jwar.basiccardgames.players.Player;

import java.util.List;

public class Rummy extends Game {

    private final static int HAND_LIMIT = 7;

    public Rummy(StandardDeck deck) {
        super(deck);
    }

    @Override
    public void startGame() {
        this.getDeck().shuffleDeck(); //Shuffle the deck
        initialDeal(); // Initial deal of 7 cards to each player
        currentPlayer = getFirstPlayer(); //Assign a first player.
        currentPlayer.receiveCard(deck.dealTopCard()); //Then give them an 8th card.
    }

    /**
     * Checks for a win condition
     * run at the end of every turn
     * If a Player has a winning combination, gameOver boolean = true.
     */
    public void isGameOver (){
        if (winningHand(currentPlayer.getHand())){
            this.gameOver = true;
            System.out.println("Congratulations " + currentPlayer.getName() + " you win!");
        }
    }

    private void initialDeal(){
        for (Player player: players){
            deal(player, HAND_LIMIT);
        }
    }

    //Work on this next
    public boolean winningHand(List<Card> hand){
        //Compare the hand argument to all winning hands
        return true;
    }


    @Override
    public String toString() {
        return super.toString() + " playing Rummy";
    }
}
