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
                     Melon
                    /     \
               Banana     Orange
               /    \          \
           Apple   Cherry   Pineapple
                  /    \       
           Blueberry   Mango
                      /
                   Grapes
         */

        System.out.println("Red Bloack tree: ");
        System.out.println(tree);
    }
}