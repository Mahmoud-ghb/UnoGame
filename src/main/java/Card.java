public class Card {
    private CardColor color;
    private String value;

    public Card(CardColor color, String value) {
        this.color = color;
        this.value = value;
    }

    // Getters and setters
    public CardColor getColor(){
        return this.color;
    }
    public void setColor(CardColor color){
        this.color = color;
    }
    public String getValue(){
        return this.value;
    }
}
