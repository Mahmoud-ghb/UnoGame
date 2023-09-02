import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (CardColor color : CardColor.values()) {
            if (color != CardColor.BLACK) { // Exclude BLACK color for numbered cards
                cards.add(new Card(color, "0"));
                for (int i = 0; i < 2; i++) {
                    for (int value = 1; value < 10; value++) {
                        cards.add(new Card(color, String.valueOf(value)));
                    }

                    cards.add(new Card(color, "Reverse"));
                    cards.add(new Card(color, "Skip"));
                    cards.add(new Card(color, "Draw Two"));
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            cards.add(new Card(CardColor.BLACK, "Wild"));
            cards.add(new Card(CardColor.BLACK, "Wild Draw Four"));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("the deck is empty");
        }
        return cards.remove(cards.size() - 1);
    }

    public void revertCardToEnd(Card card){
        cards.add(0,card);
    }
}
