package treeset;

import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(3);
        set.add(8);
        set.add(5); // Duplicate, will not be added
        set.add(1);

        System.out.println("Set contains 3: " + set.contains(3));
        System.out.println("Set contains 7: " + set.contains(7));

        System.out.println("Elements in sorted order:");
        for (Integer element : set) {
            System.out.println(element);
        }

    }

}
