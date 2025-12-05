public class Node {

    private int data;
    private Node leftChild;
    private Node rightChild;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {

        if (value == data) {
            return; // no duplicates
        }

        if (value < data) {
            if (leftChild == null) {
                leftChild = new Node(value);
            } else {
                leftChild.insert(value);
            }
        } else {
            if (rightChild == null) {
                rightChild = new Node(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    // Original
    public void traverseInOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }

        System.out.println("Data: " + data);

        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    // Descending version
    public void traverseInOrderDescending() {
        if (rightChild != null) {
            rightChild.traverseInOrderDescending();
        }

        System.out.println("Data: " + data);

        if (leftChild != null) {
            leftChild.traverseInOrderDescending();
        }
    }

    public Node get(int value) {

        if (value == data) {
            return this;
        }

        if (value < data) {
            return (leftChild != null) ? leftChild.get(value) : null;
        } else {
            return (rightChild != null) ? rightChild.get(value) : null;
        }
    }


    public int getData() {
        return data;
    }
    public Node getRightChild() {
        return rightChild;
    }
    public Node getLeftChild() {
        return leftChild;
    }

    @Override
    public String toString() {
        return "Node{data=" + data + '}';
    }
}