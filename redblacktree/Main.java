package redblacktree;

public class Main {
    
    public static void main(String[] args) {
        // Sample usage
        RedBlackTree<String> tree = new RedBlackTree<>();
        tree.add("Melon"); 
        tree.add("Banana");
        tree.add("Cherry");
        tree.add("Blueberry");
        tree.add("Mango");
        tree.add("Apple");
        tree.add("Orange");
        tree.add("Grapes");
        tree.add("Pineapple");
        /*
                     Cherry(B)
                  /           \
        Banana(B)            Melon(R)
        /    \                /     \
    Apple(R) Blueberry(R)   Mango(B) Orange(B)
                            /            \
                        Grapes(R).      Pineapple(R)
         */

        System.out.println("Red Bloack tree: ");
        System.out.println(tree);

        String treeInOrderRepresentation = "In-Order: [Apple(R) ↗ Banana(B) ↘ Blueberry(R)] ↗ Cherry(B) ↘ [[Grapes(R) ↗ Mango(B)] ↗ Melon(R) ↘ [Orange(B) ↘ Pineapple(R)]]";
        if (tree.toString().equals(treeInOrderRepresentation)) {
            System.out.println("✅ The red-black tree structure is correct.");
        } else {
            System.out.println("❌ The red-black tree structure is incorrect.");
        }
    }
}