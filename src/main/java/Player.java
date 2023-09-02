import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    // Getters, setters, and additional methods for interacting with the player's hand
    public String getName(){
        return this.name;
    }

    public void addCardToHand(Card card){
        hand.add(card);
    }

    public int getHandSize(){
        return hand.size();
    }

    public List<Card> getHand(){
        return hand;
    }

    public Card getCard(int index){
        if (index < 0 || index >= hand.size())
            throw new IllegalStateException("Invalid index");
        return hand.get(index);
    }
    public Card playCard(int index){
        if (index < 0 || index >= hand.size())
            throw new IllegalStateException("Invalid index");
        return hand.remove(index);
    }
}
