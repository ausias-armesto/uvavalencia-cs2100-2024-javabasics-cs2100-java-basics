package linkedlists;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        // Sample usage
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        
        System.out.println("Initial list: " + list);
        
        list.remove("Banana");
        System.out.println("After removing 'Banana': " + list);
        
        System.out.println("Does the list contain 'Cherry'? " + list.contains("Cherry"));
        System.out.println("Does the list contain 'Orange'? " + list.contains("Orange"));
        System.out.println("Size of the list: " + list.size());


        List<String> list2 = new ArrayList<>();
        list2.add("Apple");
        list2.add("Banana");
        list2.add("Cherry");
        list2.add("Orange");
        printList(list2);
        printElement("Banana");

    }

    // Linear cost
    public static void printList(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    // Constant cost
    public static void printElement(String element) {
        System.out.println(element);
    }
}