import java.util.ArrayList;
import java.util.List;

public class DiscardPile {
    private List<Card> cards;

    public DiscardPile() {
        cards = new ArrayList<>();
    }

    public void discardCard(Card card) {
        cards.add(card);
        // Add the card to the discard pile
    }

    public Card getTopCard() {
        // Return the top card from the discard pile
        if (cards.isEmpty()) {
            // Handle case when deck is empty, e.g., reshuffling the discard pile
            throw new IllegalStateException("At least 1 Card required to return.");
        }
        return cards.get(cards.size() - 1);
    }

    // Additional methods for interacting with the discard pile
}
