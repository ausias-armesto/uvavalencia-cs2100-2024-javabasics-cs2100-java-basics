package hashmaps;
import java.util.HashMap;
import java.util.Map;

public class Main {
    

    public static void main(String[] args) {
        // Your HashMap code would go here
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(2, "Two Updated"); // Duplicate key, value will be updated
        map.put(null, "Null Key"); // HashMap allows null keys

        System.out.println("Value for key 2: " + map.get(2));
        System.out.println("Value for key 4: " + map.get(4)); // Key not present

        System.out.println("Entries in the map:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
