public class Main {

    public static void main(String[] args) {
        Player player1 = new Player(1, "Ace");
        Player player2 = new Player(2, "Blaze");
        Player player3 = new Player(3, "Coda");

        SimpleHashtable hashtable = new SimpleHashtable();
        hashtable.put("1", player1);
        hashtable.put("2", player2);
        hashtable.put("3", player3);

        System.out.println("Hashtable after inserting 3 players:");
        hashtable.printHashtable();

        System.out.println("\nGet key 2:");
        System.out.println(hashtable.get("2"));

        System.out.println("\nRemoving key 2...");
        hashtable.remove("2");

        System.out.println("\nHashtable after removal:");
        hashtable.printHashtable();
    }
}