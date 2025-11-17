package trees;

public class BinaryTree<T> {
    
    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    private int getHeight(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
    * Returns the first node at this level that has a missing child.
    * Returns null if none exists.
    */
    private Node<T> findAvailableInLevel(Node<T> node, int level) {
        if (node == null) return null;

        if (level == 1) {
            // We are at the desired level
            if (node.getLeft() == null || node.getRight() == null) {
                return node;
            }
            return null;
        }

        // Recur on left subtree
        Node<T> leftResult = findAvailableInLevel(node.getLeft(), level - 1);
        if (leftResult != null) return leftResult;

        // Recur on right subtree
        return findAvailableInLevel(node.getRight(), level - 1);
    }

    /**
    * Returns the next parent (in level-order) that has space for a new child.
    */
    private Node<T> findNextInsertionParent(Node<T> root) {
        if (root == null) return null;
        for (int level = 1; level <= getHeight(root); level++) {
            Node<T> candidate = findAvailableInLevel(root, level);
            if (candidate != null) {
                return candidate;
            }
        }

        return null; // Should never happen unless tree is perfect
    }

    public Node<T> getRoot() {
        return root;
    }

    public void add(T data) {
        if (root == null) {
            root = new Node<T>(data);
            return;
        }
        Node<T> parent = findNextInsertionParent(root);
        if (parent.getLeft() == null) {
            parent.setLeft(new Node<T>(data));
        } else {
            parent.setRight(new Node<T>(data));
        }
    }

}
