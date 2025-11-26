package queues;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        // Adding elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Adding elements to the list for demonstration
        list = new LinkedList<>(queue);

        System.out.println("Queue after adding elements: " + queue);
        System.out.println("List after copying elements: " + list);

        // Removing an element from the queue
        int removedElement = queue.remove();
        System.out.println("Removed element: " + removedElement);
        System.out.println("Queue after removing an element: " + queue);
        list.remove(0);
        System.out.println("List removed element: " + removedElement);
        System.out.println("List after removing an element: " + list);


        // Peeking at the front element of the queue
        int frontElement = queue.peek();
        int listFirstElement = list.get(0);
        System.out.println("Front element: " + frontElement);
        System.out.println("List first element: " + listFirstElement);
        System.out.println("Queue after peeking: " + queue);

        // Checking if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? " + isEmpty);
        System.out.println("Is the list empty? " + list.isEmpty());

        // Getting the size of the queue
        int size = queue.size();
        System.out.println("Size of the queue: " + size);
        System.out.println("Size of the list: " + list.size());
    }
    
}
