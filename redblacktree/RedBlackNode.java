package redblacktree;
import java.awt.Color;

public class RedBlackNode<T extends Comparable<T>> {

    private T data;

    private RedBlackNode<T> parent;
    private RedBlackNode<T> left;
    private RedBlackNode<T> right;
    private Color color;

    public RedBlackNode() {}

    public RedBlackNode(T val, RedBlackNode<T> parent) { 
        this.data = val; 
        this.parent = parent;
        this.color = Color.RED; // New nodes are typically red in a red-black tree
    }

    public T getData() { 
        return data; 
    }

    public void setData(T data) { 
        this.data = data; 
    }

    public RedBlackNode<T> getLeft() { 
        return left; 
    }

    public void setLeft(RedBlackNode<T> next) { 
        this.left = next; 
    }

    public RedBlackNode<T> getRight() { 
        return right; 
    }

    public void setRight(RedBlackNode<T> right) { 
        this.right = right; 
    }

    public RedBlackNode<T> getParent() {
        return parent;
    }

    public void setParent(RedBlackNode<T> parent) {
        this.parent = parent;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public RedBlackNode<T> getUncle() {
        if (parent == null || parent.getParent() == null) {
            return null;
        }
        RedBlackNode<T> grandParent = parent.getParent();
        if (grandParent.getLeft() == parent) { // If parent is left child
            return grandParent.getRight();
        } else { // If parent is right child
            return grandParent.getLeft();
        }
    }

    public boolean isLeftChild() {
        return this.parent != null && this.parent.getLeft() == this;
    }

    public boolean isRightChild() {
        return this.parent != null && this.parent.getRight() == this;
    }
}
