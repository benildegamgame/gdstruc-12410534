import java.util.LinkedList;

public class CardStack {
    private LinkedList<Card> stack = new LinkedList<>();

    public void push(Card card) {
        stack.addFirst(card);
    }

    public Card pop() {
        if (stack.isEmpty()) return null;
        return stack.removeFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public String toString() {
        return stack.toString();
    }
}