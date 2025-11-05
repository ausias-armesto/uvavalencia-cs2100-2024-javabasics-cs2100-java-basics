package linkedlists;

public class MyLinkedList<T> {
    
    private Node<T> head;

    public MyLinkedList() {
        head = null;
    }

    // Add a new element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head.getNext()); // Set the new node's next to the current head's next
            head.setNext(newNode); // Set the current head's next to the new node
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
        while (current.getNext() != null && !current.getNext().getData().equals(data)) { // Traverse the list to find the node to remove
            current = current.getNext();
        }

        if (current.getNext() != null) { // Found the node to remove if not the end of the LinkedList
            current.setNext(current.getNext().getNext());  // Bypass the node to remove
        }
    }

    @Override
    public String toString() {
        Node<T> current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) { // Traverse the LinkedList
            sb.append(current.getData());
            current = current.getNext(); // Move to the next node
            if (current != null) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }

// Check if the list contains an element
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) { // Traverse the LinkedList
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
        while (current != null) { // Traverse the LinkedList
            count++;
            current = current.getNext();
        }
        return count;
    }
}
