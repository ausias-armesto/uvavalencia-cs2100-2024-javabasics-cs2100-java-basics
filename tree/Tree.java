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
        if (current == null) {
            current = newNode;
        } else if (newNode.getData().compareTo(current.getData()) < 0) {
            if (current.getLeft() == null) {
                current.setLeft(newNode);
            } else {
                addRecursive(current.getLeft(), newNode);
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(newNode);
            } else {
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

        if (data.compareTo(current.getData()) < 0) {
            current.setLeft(removeRecursive(current.getLeft(), data));
        } else if (data.compareTo(current.getData()) > 0) {
            current.setRight(removeRecursive(current.getRight(), data));
        } else {
            // Node to remove found
            if (current.getLeft() == null) {
                return current.getRight();
            } else if (current.getRight() == null) {
                return current.getLeft();
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            Node<T> successor = findMin(current.getRight());
            current.setData(successor.getData());
            current.setRight(removeRecursive(current.getRight(), successor.getData()));
        }
        return current;
    }

    private Node<T> findMin(Node<T> current) {
        while (current.getLeft() != null) {
            current = current.getLeft();
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
            current = current.getLeft();
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
