import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args) {

        System.out.println();


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();

        Game game = new CustomUnoGame(); // Instantiate the desired game variation


        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name of player " + (i + 1) + ": ");
            String playerName = scanner.next();
            game.addPlayer(new Player(playerName));
        }

        game.play();


    }
}
