package linkedlists;

public class LinkedList<T> {
    
    private Node<T> head;

    public LinkedList() {
        head = null;
    }

    // Add a new element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        
        if (head == null) {
            head = newNode;
        } else {
            // newNode.next = head.next;
            // head.next = newNode;
            newNode.setNext(head.getNext());
            head.setNext(newNode);
        }
    }

    // Remove an element from the list (first occurrence)
    public void remove(T data) {
        if (head == null) {
            return;  // List is empty
        }

        if (head.getData().equals(data)) {
            head = head.getNext();  // Remove the head node
            return;
        }

        Node<T> current = head;
        while (current.getNext() != null && !current.getNext().getData().equals(data)) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());  // Bypass the node to remove
        }
    }

    @Override
    public String toString() {
        Node<T> current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getData());
            sb.append(" -> ");
            current = current.getNext();
        }
        return sb.toString();
    }

// Check if the list contains an element
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    // Get the size of the list
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
}
