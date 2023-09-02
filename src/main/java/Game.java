import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    protected List<Player> players;
    protected Deck deck;
    protected DiscardPile discardPile;

    public Game() {
        players = new ArrayList<>();
        deck = new Deck();
        discardPile = new DiscardPile();
    }

    public abstract void initializeGame();

    public abstract boolean isGameOver();

    public abstract void play();

    protected abstract void startTurn();

    protected abstract void playTurn();

    protected abstract void endTurn();

    protected abstract void displayWinner();

    public abstract void addPlayer(Player player);

    // Additional common methods for handling player turns, drawing cards, etc.
}
