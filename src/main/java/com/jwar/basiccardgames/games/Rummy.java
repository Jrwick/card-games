package com.jwar.basiccardgames.games;

import com.jwar.basiccardgames.decks.StandardDeck;
import com.jwar.basiccardgames.players.Player;

public class Rummy extends Game {

    private final static int HAND_LIMIT = 7;

    public Rummy(StandardDeck deck) {
        super(deck);
    }

    @Override
    public void startGame() {
        this.getDeck().shuffleDeck();
        initialDeal();
        currentPlayer = getFirstPlayer();
        currentPlayer.receiveCard(deck);
    }

    private void initialDeal(){
        for (Player player: players){
            deal(player, HAND_LIMIT);
        }
    }



    @Override
    public String toString() {
        return super.toString() + " playing Rummy";
    }
}
