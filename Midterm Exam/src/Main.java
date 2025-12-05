import java.util.*;

public class Main {

    public static void pause() {
        System.out.println("Press ENTER to continue...");
        try {
            System.in.read();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        Random rand = new Random();

        // Initialize deck/stack
        CardStack deck = new CardStack();
        CardStack discardPile = new CardStack();
        List<Card> hand = new ArrayList<>();

        // Create cards
        String[] names = {
                "Sir Dale", "Sir Keiji", "Sir Abet", "Sir Pip", "Sir Pado",
                "Sir Normz", "Doc B", "Sir Kevin", "Sir Roan", "Sir G"
                // its the entire squad :D
        };

        // Fills/refills deck
        for (int i = 0; i < 30; i++) {
            String name = names[rand.nextInt(names.length)];
            deck.push(new Card(name));
        }

        System.out.println("\nIt's the Game Dev Prof Trading Card Game!\n\nTry to grab as many profs as you can, and avoid running out of cards!");

        // Gameplay
        while (!deck.isEmpty()) {
            System.out.println("\n====== New Turn ======");

            int command = rand.nextInt(3); // 0 = draw, 1 = discard, 2 = get from discard
            int x = rand.nextInt(5) + 1;   // 1 to 5 cards

            switch (command) {
                case 0: // Draw cards
                    System.out.println("Draw " + x + " cards");
                    for (int i = 0; i < x; i++) {
                        Card c = deck.pop();
                        if (c != null) {
                            hand.add(c);
                        } else {
                            System.out.println("You have no cards in your deck!");
                            break;
                        }
                    }
                    break;

                case 1: // discard cards
                    System.out.println("Discard " + x + " cards");
                    for (int i = 0; i < x && !hand.isEmpty(); i++) {
                        Card removed = hand.remove(hand.size() - 1);
                        discardPile.push(removed);
                    }
                    break;

                case 2: // get cards from discard pile
                    System.out.println("Get " + x + " card(s) from discard pile");
                    for (int i = 0; i < x; i++) {
                        Card card = discardPile.pop();
                        if (card != null) {
                            hand.add(card);
                        } else {
                            System.out.println("There are no cards in the Discard Pile!");
                            break;
                        }
                    }
                    break;
            }

            // displays the player's status
            System.out.println("Cards on Hand: " + hand);
            System.out.println("Cards left in Deck: " + deck.size());
            System.out.println("Cards in Discard Pile: " + discardPile.size());
            pause();
        }

        System.out.println("\n====== GAME SET! ======");
        System.out.println("Final Hand: " + hand);
        System.out.println("Discard Pile: " + discardPile);
        System.out.println("\nDeck has been emptied, and all the professors have gone home.\nThank you for playing!");
    }
}