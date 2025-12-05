public class Tree {

    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public void traverseInOrderDescending() {
        if (root != null) {
            root.traverseInOrderDescending();
        }
    }

    public Node get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    // getMin()
    public Node getMin() {
        if (root == null) return null;

        Node current = root;
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current;
    }

    // getMax()
    public Node getMax() {
        if (root == null) return null;

        Node current = root;
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
    }
}