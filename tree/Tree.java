package tree;

public class Tree<T extends Comparable<T>> {
    
    private Node<T> root;

    public Tree() {
        root = null;
    }

    // Add a new element to the tree
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (root == null) {
            root = newNode;
        } else {
            addRecursive(root, newNode);
        }
    }

    private void addRecursive(Node<T> current, Node<T> newNode) {
        // Base case: If current is null, we've found the spot to insert
        if (current == null) {
            current = newNode;
        } else if (newNode.getData().compareTo(current.getData()) < 0) { // Go left
            if (current.getLeft() == null) { // Insert in left empty subtree
                current.setLeft(newNode);
            } else { // Continue traversing left to find the appropriate spot
                addRecursive(current.getLeft(), newNode);
            }
        } else { // Go right
            if (current.getRight() == null) { // Insert in right empty subtree
                current.setRight(newNode);
            } else { // Continue traversing right to find the appropriate spot
                addRecursive(current.getRight(), newNode);
            }
        }
    }

    // Remove an element from the tree
    public void remove(T data) {
        root = removeRecursive(root, data);
    }

    private Node<T> removeRecursive(Node<T> current, T data) {
        if (current == null) {
            return null;
        }

        if (data.compareTo(current.getData()) < 0) { // Go left
            current.setLeft(removeRecursive(current.getLeft(), data));
        } else if (data.compareTo(current.getData()) > 0) { // Go right
            current.setRight(removeRecursive(current.getRight(), data));
        } else { // Node to remove found
            if (current.getLeft() == null) { // Node with only right child or no child
                return current.getRight();
            } else if (current.getRight() == null) { // Node with only left child or no child
                return current.getLeft();
            }
            // Node with two children: Get the inorder successor (smallest in the right subtree). We could alternatively use the inorder predecessor (largest in the left subtree).
            Node<T> successor = findMin(current.getRight());
            current.setData(successor.getData());
            // Delete the inorder successor from the right subtree
            current.setRight(removeRecursive(current.getRight(), successor.getData()));
        }
        return current;
    }

    public Node<T> findMin(Node<T> current) {
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public Node<T> findMax(Node<T> current) {
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }


    // Print in-order traversal
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("In-Order: ");
        printInOrder(root, sb);
        sb.append("\nPre-Order: ");
        printPreOrder(root, sb);
        sb.append("\nPost-Order: ");
        printPostOrder(root, sb);
        sb.append("\nLevel-Order: ");
        printLevelOrder(root, sb);
        return sb.toString();
    }

    private void printInOrder(Node<T> node, StringBuilder sb) {
        // TODO: Implement this method
    }

    private void printPreOrder(Node<T> node, StringBuilder sb) {
        // TODO: Implement this method
    }

    private void printPostOrder(Node<T> node, StringBuilder sb) {
        // TODO: Implement this method
    }

    private void printLevelOrder(Node<T> node, StringBuilder sb) {
        // TODO: Implement this method
    }

// Check if the list contains an element
    public boolean contains(T data) {
        Node<T> current = root;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            // Traverse left or right based on comparison
            current = (current.getData().compareTo(data) > 0) ? current.getLeft() : current.getRight();
        }
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isTwoTree() {
        // TODO: Implement this method
        return false;
    }

    public boolean isFullTree() {
        // TODO: Implement this method
        return false;
    }

    public boolean isCompleteTree() {
        // TODO: Implement this method
        return false;
    }

    public int height() {
      // TODO: Implement this method
      return 0;
    }

    public int size() {
      // TODO: Implement this method
        return 0;
    }
}
