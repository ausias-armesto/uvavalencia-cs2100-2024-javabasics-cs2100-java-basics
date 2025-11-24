package queues;

public class Main {

    public static void main(String[] args) {
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();

        // Adding elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Queue after adding elements: " + queue);

        // Removing an element from the queue
        int removedElement = queue.remove();
        System.out.println("Removed element: " + removedElement);
        System.out.println("Queue after removing an element: " + queue);

        // Peeking at the front element of the queue
        int frontElement = queue.peek();
        System.out.println("Front element: " + frontElement);
        System.out.println("Queue after peeking: " + queue);

        // Checking if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? " + isEmpty);

        // Getting the size of the queue
        int size = queue.size();
        System.out.println("Size of the queue: " + size);
    }
    
}
