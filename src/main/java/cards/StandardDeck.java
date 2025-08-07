package cards;

import java.util.ArrayList;
import java.util.List;

public class StandardDeck {
    private final List<Card> cards;

    public StandardDeck(){
        cards = new ArrayList<>();
    }

    //need to implement a loop to generate a standard 52 card deck
    private void populateDeck(){
        var card = new Card(Card.Suit.DIAMONDS, 5);
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }
}
