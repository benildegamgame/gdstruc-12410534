import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(10);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int gameCount = 0;
        int playerIdCounter = 1;

        System.out.println("=== Matchmaking has started! Make war, not love! ===\n");

        while (gameCount < 10) {

            System.out.println("\nPress ENTER to continue...");
            scanner.nextLine();

            // Players joining, up to 7 only
            int playersJoining = random.nextInt(7) + 1;
            System.out.println(playersJoining + " players joined matchmaking!");

            // Add players to queue
            for (int i = 0; i < playersJoining; i++) {
                Player p = new Player(playerIdCounter, "Player" + playerIdCounter, random.nextInt(200));
                queue.add(p);
                playerIdCounter++;
            }

            System.out.println("\nCurrent Queue:");
            queue.printQueue();

            // Matchmaking
            if (queue.size() >= 5) {
                System.out.println("\n--- Match found! Get ready to rumble... " + (gameCount + 1) + " ---");
                System.out.println("Players in the match:");

                for (int i = 0; i < 5; i++) {
                    Player matchedPlayer = queue.remove();
                    System.out.println(matchedPlayer);
                }

                gameCount++;
            }

            System.out.println("\nGames Completed: " + gameCount + "/10");
        }

        System.out.println("\n=== All Games Completed! Matchmaking is now shut down for maintenance... ===");
    }
}
