package trees.avl;

public class AVLTree<T extends Comparable<T>> {
    
    private AVLNode<T> root;

    public AVLTree() {
        this.root = null;
    }


    // ---------- Helper methods ----------
    // Returns the height of the given node.
    private int height(AVLNode<T> node) {
        return node == null ? -1 : node.getHeight();
    }

    // Updates the height of the given node based on its children's heights.
    private void updateHeight(AVLNode<T> node) {
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
    }

    private int balanceFactor(AVLNode<T> node) {
        return height(node.getLeft()) - height(node.getRight());
    }

    // ---------- Rotations ----------
    private AVLNode<T> rotateLeft(AVLNode<T> node) {
        AVLNode<T> rightChild = node.getRight();
        AVLNode<T> grandchild = rightChild.getLeft();

        rightChild.setLeft(node);
        node.setRight(grandchild);

        // Update parents
        rightChild.setParent(node.getParent());
        node.setParent(rightChild);
        if (grandchild != null) grandchild.setParent(node);

        // Update parent reference
        if (rightChild.getParent() != null) {
            if (rightChild.getParent().getLeft() == node) {
                rightChild.getParent().setLeft(rightChild);
            } else {
                rightChild.getParent().setRight(rightChild);
            }
        } else {
            root = rightChild;
        }

        // Update heights
        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    private AVLNode<T> rotateRight(AVLNode<T> node) {
        AVLNode<T> leftChild = node.getLeft();
        AVLNode<T> grandchild = leftChild.getRight();

        leftChild.setRight(node);
        node.setLeft(grandchild);

        // Update parents
        leftChild.setParent(node.getParent());
        node.setParent(leftChild);
        if (grandchild != null) grandchild.setParent(node);

        // Update parent reference
        if (leftChild.getParent() != null) {
            if (leftChild.getParent().getLeft() == node) {
                leftChild.getParent().setLeft(leftChild);
            } else {
                leftChild.getParent().setRight(leftChild);
            }
        } else {
            root = leftChild;
        }

        // Update heights
        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }

    // ---------- Rebalance ----------
    private void rebalance(AVLNode<T> node) {
        AVLNode<T> current = node;

        while (current != null) {
            updateHeight(current);
            int bf = balanceFactor(current);

            if (bf == 2) { // Left heavy
                if (balanceFactor(current.getLeft()) < 0) {
                    rotateLeft(current.getLeft()); // Left-Right case
                }
                rotateRight(current); // Left-Left case
            } else if (bf == -2) { // Right heavy
                if (balanceFactor(current.getRight()) > 0) {
                    rotateRight(current.getRight()); // Right-Left case
                }
                rotateLeft(current); // Right-Right case
            }

            current = current.getParent();
        }
    }


    // Add a new element to the tree
    public void add(T data) {
        AVLNode<T> newNode = new AVLNode<T>(data, null);
        if (root == null) {
            root = newNode;
        } else {
            addRecursive(root, data);
        }
    }

    private void addRecursive(AVLNode<T> current, T data) {
        // Base case: If current is null, we've found the spot to insert
        if (data.compareTo(current.getData()) < 0) { // Go left
            if (current.getLeft() == null) { // Insert in left empty subtree
                current.setLeft(new AVLNode<>(data, current));
                rebalance(current.getLeft());
            } else { // Continue traversing left to find the appropriate spot
                addRecursive(current.getLeft(), data);
            }
        } else { // Go right
            if (current.getRight() == null) { // Insert in right empty subtree
                current.setRight(new AVLNode<>(data, current));
                rebalance(current.getRight());
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

    private void printInOrder(AVLNode<T> node, StringBuilder sb) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                sb.append(node.getData());
                return;
            }
            if (!node.equals(root)) {
                sb.append("[");
            }
            printInOrder(node.getLeft(), sb);
            if (node.getLeft() != null) {
                sb.append(" ↗ ");
            }
            sb.append(node.getData());
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
        AVLNode<T> current = root;
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
