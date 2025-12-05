public class LinkedList<E> {

    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public void add(E element) {
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        }

        E removedData = head.data;
        head = head.next;
        size--;

        return removedData;
    }

    public int size() {
        return size;
    }

    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    public int indexOf(E element) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if ((current.data == null && element == null) ||
                    (current.data != null && current.data.equals(element))) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}