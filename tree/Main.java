package tree;

public class Main {
    
    public static void main(String[] args) {
        // Sample usage
        Tree<String> tree = new Tree<>();
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

        System.out.println("Initial tree: " + tree);

        tree.remove("Banana");
        /*
                     Melon
                    /     \
               Blueberry     Orange
               /    \          \
           Apple   Cherry   Pineapple
                      \
                      Mango
                      /
                   Grapes
         */
        System.out.println("After removing 'Banana': " + tree);

        System.out.println("Does the tree contain 'Cherry'? " + tree.contains("Cherry"));
        System.out.println("Does the tree contain 'Orange'? " + tree.contains("Orange"));

    }
}