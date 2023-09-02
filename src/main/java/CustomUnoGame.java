import java.util.Scanner;

public class CustomUnoGame extends Game {
    private int currentPlayer;
    private boolean clockwise;
    private Card Wild;
    private boolean gameOver;

    @Override
    public void initializeGame() {
        // Custom initialization logic for the game variation
        System.out.println("Initializing Standard Uno Game...");

        if (players.size() < 2) {
            throw new IllegalStateException("At least 2 players required to start the game.");
        }

        deck.shuffle();

        for (int i = 0; i < 7; i++) {
            for (Player player : players)
                player.addCardToHand(deck.drawCard());
        }

        Card firstCard = deck.drawCard();
        while (firstCard.getColor() == CardColor.BLACK){
            deck.revertCardToEnd(firstCard);
            firstCard = deck.drawCard();
        }
        discardPile.discardCard(firstCard);

        Wild = firstCard;
        currentPlayer = 0;
        clockwise = true;
        gameOver = false;
    }



    @Override
    public boolean isGameOver() {
        // Custom game over conditions for the game variation
        return (players.get(currentPlayer).getHandSize() == 0);
    }

    @Override
    public void play() {
        // Custom game logic for the game variation
        initializeGame();
        while (!gameOver) {
            nextPlayer();
            startTurn();
            playTurn();
            endTurn();
        }
        displayWinner();
    }

    private void nextPlayer(){
        if(clockwise){
            if(currentPlayer + 1 < players.size())
                currentPlayer++;
            else
                currentPlayer = 0;
        }else {
            if(currentPlayer - 1 >= 0)
                currentPlayer--;
            else
                currentPlayer = players.size() - 1;
        }
    }

    @Override
    protected void startTurn() {
        Player player = players.get(currentPlayer);
        System.out.println("Player " + player.getName() + "'s turn.");
        int cardIndex = 0;
        System.out.println("Your cards : ");
        for (Card card: player.getHand()){
            System.out.println(cardIndex + " [ " + card.getValue() + " , " + card.getColor() + " ]");
            cardIndex++;
        }

        System.out.println("Wild card is [ "+Wild.getValue()+" , "+Wild.getColor()+" ]");
    }

    private boolean mustDraw(Player player){
        for (Card card: player.getHand()){
            if(card.getColor() == Wild.getColor() || card.getValue().equals(Wild.getValue()))
                return false;
        }
        return true;
    }
    @Override
    protected void playTurn() {
        Player player = players.get(currentPlayer);
        Card playedCard = null;
        Scanner scanner = new Scanner(System.in);

        if(mustDraw(player)) {
            System.out.println("you have to draw a card");
            Card drawedCard = deck.drawCard();
            System.out.println("the card you drawn is  [ " + drawedCard.getValue() + " , " + drawedCard.getColor() + " ]");
            System.out.println("do you want to play it (y/n)?");
            String ans = scanner.next();
            if (ans.equals("y")) {
                playedCard = drawedCard;
            }else {
                player.addCardToHand(drawedCard);
                return;
            }
        }else{
            System.out.println("do you want to draw a card (y/n)?");
            String ans = scanner.next();

            if (ans.equals("y")) {
                Card drawnCard = deck.drawCard();
                System.out.println(" [ " + drawnCard.getValue() + " , " + drawnCard.getColor() + " ]");
                System.out.println("do you want to play it (y/n)?");
                String ans2 = scanner.next();
                if (ans2.equals("y"))
                    playedCard = drawnCard;
                else {
                    player.addCardToHand(drawnCard);
                    return;
                }
            }else {
                System.out.print("Enter the index of card to play: ");
                int cardIndex = scanner.nextInt();

                playedCard = player.getCard(cardIndex);

                while (!playCard(playedCard)) {
                    System.out.println("Wrong card selected");

                    System.out.print("Enter the index of card to play: ");
                    cardIndex = scanner.nextInt();

                    playedCard = player.getCard(cardIndex);
                }
                player.playCard(cardIndex);
            }

        }

        discardPile.discardCard(playedCard);
        gameOver = isGameOver();
    }

    @Override
    protected void endTurn() {
        System.out.println("Your turn end");
        Card topCard = discardPile.getTopCard();
        topCard.setColor(Wild.getColor());
        Wild = topCard;
    }

    @Override
    protected void displayWinner() {
        Player player = players.get(currentPlayer);
        System.out.println("congrats, "+player.getName()+" is winner");
    }

    @Override
    public void addPlayer(Player player) {
        if(players.size() >= 10){
            throw new IllegalStateException("Maximum number of players reached.");
        }
        players.add(player);
    }

    private boolean playCard(Card playedCard){
        if(playedCard == null)
            return true;

        if (playedCard.getColor() != CardColor.BLACK
                && playedCard.getColor() != Wild.getColor()
                && !playedCard.getValue().equals(Wild.getValue())){
            return false;
        }
        if(playedCard.getColor() == CardColor.BLACK){
            changeWild();
            if(playedCard.getValue().contains("Draw"))
                drawingNextPlayer(4);
        }else if (playedCard.getValue().equals("Draw Two")){
            drawingNextPlayer(2);
        }else if (playedCard.getValue().equals("Reverse")){
            clockwise = !clockwise;
        }else if (playedCard.getValue().equals("Skip")){
            nextPlayer();
        }

        return true;
    }

    private void drawingNextPlayer(int numOfCards){
        nextPlayer();
        for(int i = 0; i < numOfCards; i++)
            players.get(currentPlayer).addCardToHand(deck.drawCard());
    }

    private void changeWild(){
        System.out.println("Current Wild Color is " + Wild.getColor());
        Scanner scanner =new Scanner(System.in);
        System.out.println("Choose an index of new Wild color [(Red , 1), (Yellow , 2), (Green , 3), (Blue , 4)]");

        int ans  = scanner.nextInt();
        while (ans < 1 || ans > 4){
            System.out.println("invalid index , please inter a number between 1 and 4");
            ans = scanner.nextInt();
        }

        switch (ans){
            case 1 : Wild.setColor(CardColor.RED); break;
            case 2 : Wild.setColor(CardColor.YELLOW); break;
            case 3 : Wild.setColor(CardColor.GREEN); break;
            default : Wild.setColor(CardColor.BLUE);
        }
    }
}
