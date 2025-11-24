package hashset;

public class Main {

    public static void main(String[] args) {
        // Your HashSet code would go here
        java.util.Set<Integer> set = new java.util.HashSet<>();
        set.add(5);
        set.add(3);
        set.add(8);
        set.add(5); // Duplicate, will not be added
        set.add(1);
        set.add(null); // HashSet allows null

        System.out.println("Set contains 3: " + set.contains(3));
        System.out.println("Set contains 7: " + set.contains(7));

        System.out.println("Elements in the set:");
        for (Integer element : set) {
            System.out.println(element);
        }
    }   
    
}
