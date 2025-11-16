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
        tree.remove("Unknown"); // Trying to remove a non-existing element
        tree.remove("Grapes"); // Removing a leaf node
        System.out.println("After removing 'Grapes': " + tree);
            /*
                        Melon
                        /     \
                Banana     Orange
                /    \          \
            Apple   Cherry   Pineapple
                    /    \       
            Blueberry   Mango
            */
        tree.remove("Orange"); // Removing a node with one child
        System.out.println("After removing 'Orange': " + tree);
         /*
                     Melon
                    /     \
               Banana     Pineapple
               /    \       
           Apple   Cherry
                  /    \       
           Blueberry   Mango
         */
        tree.remove("Banana");
        /*
                     Melon
                    /     \
               Blueberry     Orange
               /    \          \
           Apple   Cherry   Pineapple
                      \
                      Mango
         */
        System.out.println("After removing 'Banana': " + tree);

        System.out.println("Does the tree contain 'Cherry'? " + tree.contains("Cherry"));
        System.out.println("Does the tree contain 'Orange'? " + tree.contains("Orange"));

    }
}