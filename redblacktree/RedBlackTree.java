package redblacktree;

import java.awt.Color;

public class RedBlackTree<T extends Comparable<T>> {
    
    private RedBlackNode<T> root;

    public RedBlackTree() {
        root = null;
    }

    // Add a new element to the tree
    public void add(T data) {
        RedBlackNode<T> newNode = new RedBlackNode<T>(data, null);
        if (root == null) {
            root = newNode;
            root.setColor(Color.BLACK); // Root is always black
        } else {
            addRecursive(root, data);
        }
    }

    private void rotateLeft(RedBlackNode<T> node) {
        RedBlackNode<T> newParent = node.getRight();
        node.setRight(newParent.getLeft());
        if (newParent.getLeft() != null) {
            newParent.getLeft().setParent(node);
        }
        newParent.setParent(node.getParent());
        if (node.getParent() == null) {
            root = newParent;
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(newParent);
        } else {
            node.getParent().setRight(newParent);
        }
        newParent.setLeft(node);
        node.setParent(newParent);
    }

    private void rotateRight(RedBlackNode<T> node) {
        RedBlackNode<T> newParent = node.getLeft();
        node.setLeft(newParent.getRight());
        if (newParent.getRight() != null) {
            newParent.getRight().setParent(node);
        }
        newParent.setParent(node.getParent());
        if (node.getParent() == null) {
            root = newParent;
        } else if (node == node.getParent().getRight()) {
            node.getParent().setRight(newParent);
        } else {
            node.getParent().setLeft(newParent);
        }
        newParent.setRight(node);
        node.setParent(newParent);
    }

private void fixViolation(RedBlackNode<T> node) {
    while (node != root && node.getParent().getColor() == Color.RED) {
        RedBlackNode<T> parent = node.getParent();
        RedBlackNode<T> grandparent = parent.getParent();
        RedBlackNode<T> uncle = node.getUncle();

        if (grandparent == null) {
            break; // Safety check
        } else if (uncle != null && uncle.getColor() == Color.RED) { // Case 1: Uncle is red
                parent.setColor(Color.BLACK);
                uncle.setColor(Color.BLACK);
                grandparent.setColor(Color.RED);
                // Red-red violation is fixed in the child subtree, but other violations may exist up the tree
                node = grandparent; // Move up the node pointer to grandparent and continue fixing in the next loop iteration
        } else { // Case 2: Uncle is black or null
            if (parent.isLeftChild()) { // Parent is a left child
                if (node.isRightChild()) { // Fix the tree as it is left-right heavy, perform left rotation
                    rotateLeft(parent);
                    node = parent; // Update node and parent pointers
                    parent = node.getParent();
                }
                // Case 3: The tree is now left-left heavy, perform right rotation
                parent.setColor(Color.BLACK);
                grandparent.setColor(Color.RED);
                rotateRight(grandparent);
                // Red-red violation is fixed, so the the condition of the next loop iteration will be false
            } else { // Parent is a right child
                if (node.isLeftChild()) { // Fix the tree as it is right-left heavy, perform right rotation
                    rotateRight(parent);
                    node = parent; // Update node and parent pointers
                    parent = node.getParent();
                }
                // Case 3: The tree is now right-right heavy, perform left rotation
                parent.setColor(Color.BLACK);
                grandparent.setColor(Color.RED);
                rotateLeft(grandparent);
                // Red-red violation is fixed, so the the condition of the next loop iteration will be false
            }
        }
    }
    root.setColor(Color.BLACK);
}

    private void addRecursive(RedBlackNode<T> current, T data) {
        // Base case: If current is null, we've found the spot to insert
        if (data.compareTo(current.getData()) < 0) { // Go left
            if (current.getLeft() == null) { // Insert in left empty subtree
                current.setLeft(new RedBlackNode<>(data, current));
                fixViolation(current.getLeft());
            } else { // Continue traversing left to find the appropriate spot
                addRecursive(current.getLeft(), data);
            }
        } else { // Go right
            if (current.getRight() == null) { // Insert in right empty subtree
                current.setRight(new RedBlackNode<>(data, current));
                fixViolation(current.getRight());
            } else { // Continue traversing right to find the appropriate spot
                addRecursive(current.getRight(), data);
            }
        }
    }


    // Print in-order traversal
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("In-Order: ");
        printInOrder(root, sb);
        return sb.toString();
    }

    private void printInOrder(RedBlackNode<T> node, StringBuilder sb) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                sb.append(node.getData() + "(" + (node.getColor() == Color.RED ? "R" : "B") + ")");
                return;
            }
            if (!node.equals(root)) {
                sb.append("[");
            }
            printInOrder(node.getLeft(), sb);
            if (node.getLeft() != null) {
                sb.append(" ↗ ");
            }
            sb.append(node.getData() + "(" + (node.getColor() == Color.RED ? "R" : "B") + ")");
            if (node.getRight() != null) {
                sb.append(" ↘ ");
            }
            printInOrder(node.getRight(), sb);
            if (!node.equals(root)) {
                sb.append("]");
            }
        }
    }

    // Check if the list contains an element
    public boolean contains(T data) {
        RedBlackNode<T> current = root;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            // Traverse left or right based on comparison
            current = (current.getData().compareTo(data) > 0) ? current.getLeft() : current.getRight();
        }
        return false;
    }

}
