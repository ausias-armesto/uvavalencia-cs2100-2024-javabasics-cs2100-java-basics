package trees.avl;

public class Main {
    
    public static void main(String[] args) {
        // Sample usage
        AVLTree<String> tree = new AVLTree<>();
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

        System.out.println("AVL tree: ");
        System.out.println(tree);

        String treeInOrderRepresentation = "In-Order: [Apple ↗ Banana ↘ Blueberry] ↗ Cherry ↘ [[Grapes ↗ Mango] ↗ Melon ↘ [Orange ↘ Pineapple]]";
        if (tree.toString().equals(treeInOrderRepresentation)) {
            System.out.println("✅ The AVL tree structure is correct.");
        } else {
            System.out.println("❌ The AVL tree structure is incorrect.");
        }
    }
}