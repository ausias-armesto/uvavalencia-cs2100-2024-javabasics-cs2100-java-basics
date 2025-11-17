package trees.redblack;
import java.awt.Color;

import trees.Node;

public class RedBlackNode<T extends Comparable<T>> extends Node<T> {

    private RedBlackNode<T> parent;
    private Color color;

    public RedBlackNode() {}

    public RedBlackNode(T val, RedBlackNode<T> parent) { 
        super(val);
        this.parent = parent;
        this.color = Color.RED; // New nodes are typically red in a red-black tree
    }

    @Override
    public RedBlackNode<T> getLeft() { 
        return (RedBlackNode<T>) super.getLeft(); 
    }

    public void setLeft(RedBlackNode<T> next) { 
        super.setLeft(next); 
    }

    @Override
    public RedBlackNode<T> getRight() { 
        return (RedBlackNode<T>) super.getRight(); 
    }

    public void setRight(RedBlackNode<T> right) { 
        super.setRight(right); 
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
            return (RedBlackNode<T>) grandParent.getRight();
        } else { // If parent is right child
            return (RedBlackNode<T>) grandParent.getLeft();
        }
    }

    public boolean isLeftChild() {
        return this.parent != null && this.parent.getLeft() == this;
    }

    public boolean isRightChild() {
        return this.parent != null && this.parent.getRight() == this;
    }
}
