package com.jwar.basiccardgames.main;

import com.jwar.basiccardgames.decks.StandardDeck;
import com.jwar.basiccardgames.games.Rummy;
import com.jwar.basiccardgames.players.Player;

public class Main {

    public static void main(String[] args) {

        var deck1 = new StandardDeck();
        var p1 = new Player("Josh");
        var p2 = new Player("Mike");

        var rummyGame = new Rummy(deck1);

        rummyGame.addPlayer(p1);
        rummyGame.addPlayer(p2);

        System.out.println(rummyGame);

        rummyGame.startGame();

        System.out.println("Unsorted Hand:");
        System.out.println(p1.getHand());
        p1.sortHandByValueFirst();
        System.out.println("Sorted by value:");
        System.out.println(p1.getHand());
        p1.sortHandBySuitFirst();
        System.out.println("Sorted by suit:");
        System.out.println(p1.getHand());

        System.out.println();

        System.out.println("Unsorted Hand:");
        System.out.println(p2.getHand());
        p2.sortHandByValueFirst();
        System.out.println("Sorted by value:");
        System.out.println(p2.getHand());
        p2.sortHandBySuitFirst();
        System.out.println("Sorted by suit:");
        System.out.println(p2.getHand());
        rummyGame.isGameOver();



    }
}
