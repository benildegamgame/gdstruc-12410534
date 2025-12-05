public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("Typhlosion");
        list.add("Feraligatr");
        list.add("Meganium");
        list.add("Togepi");

        list.printList();

        System.out.println("Size: " + list.size());
        System.out.println("Does it contain 'Asuna'? " + list.contains("Asuna"));
        System.out.println("Index of 'Typhlosion': " + list.indexOf("Typhlosion"));

        list.removeFirst();
        list.printList();
        System.out.println("Size: " + list.size());
    }
}