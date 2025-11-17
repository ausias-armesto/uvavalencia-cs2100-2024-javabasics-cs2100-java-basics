package trees.avl;

public class AVLNode<T extends Comparable<T>> {

    private T data;

    private AVLNode<T> parent;
    private AVLNode<T> left;
    private AVLNode<T> right;
    private int height;


    public AVLNode() {}

    public AVLNode(T val, AVLNode<T> parent) { 
        this.data = val; 
        this.parent = parent;
        this.height = 0;
        this.left = null;
        this.right = null;
    }

    public T getData() { 
        return data; 
    }

    public void setData(T data) { 
        this.data = data; 
    }

    public AVLNode<T> getLeft() { 
        return left; 
    }

    public void setLeft(AVLNode<T> next) { 
        this.left = next; 
    }

    public AVLNode<T> getRight() { 
        return right; 
    }

    public void setRight(AVLNode<T> right) { 
        this.right = right; 
    }

    public AVLNode<T> getParent() {
        return parent;
    }

    public void setParent(AVLNode<T> parent) {
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isLeftChild() {
        return this.parent != null && this.parent.getLeft() == this;
    }

    public boolean isRightChild() {
        return this.parent != null && this.parent.getRight() == this;
    }

}
