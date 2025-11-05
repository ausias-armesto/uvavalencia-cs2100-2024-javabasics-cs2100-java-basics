package linkedlists;

public class Main {
    
    public static void main(String[] args) {
        // Sample usage
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        
        System.out.println("Initial list: " + list);
        
        list.remove("Banana");
        System.out.println("After removing 'Banana': " + list);
        
        System.out.println("Does the LinkedList contain 'Cherry'? " + list.contains("Cherry"));
        System.out.println("Does the LinkedList contain 'Orange'? " + list.contains("Orange"));
        System.out.println("Size of the LinkedList: " + list.size());

    }


}