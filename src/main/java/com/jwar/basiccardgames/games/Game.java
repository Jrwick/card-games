package com.jwar.basiccardgames.games;

import com.jwar.basiccardgames.decks.EmptyDeck;
import com.jwar.basiccardgames.decks.StandardDeck;
import com.jwar.basiccardgames.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Game {

    protected final List<Player> players;
    protected final StandardDeck deck;
    protected final EmptyDeck discardPile;
    protected Player currentPlayer;

    public Game(StandardDeck deck){
        this.deck = deck;
        this.players = new ArrayList<>();
        this.discardPile = new EmptyDeck();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public StandardDeck getDeck() {
        return deck;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void deal(Player player, int numOfCards){
        for (int i = 0; i < numOfCards; i++){
            player.receiveCard(deck.dealTopCard());
        }
    }

    public Player getFirstPlayer(){
        Random ran = new Random();
        if (players.isEmpty()){
            return null;
        } else {
            return players.get(ran.nextInt(players.size()));
        }
    }

    public abstract void startGame();

    @Override
    public String toString() {
        ArrayList<String> names = new ArrayList<>();
        for (Player player: players){
            names.add(player.getName());
        }
        return players.size() + " players: " + String.join(", ", names);
    }
}
