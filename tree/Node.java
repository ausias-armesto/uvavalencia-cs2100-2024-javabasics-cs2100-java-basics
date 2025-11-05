package tree;

public class Node<T extends Comparable<T>> {

    private T data;

    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;

    public Node() {}

    public Node(T val) { 
        this.data = val; 
    }

    public Node(T val, Node<T> parent, Node<T> left, Node<T> right) { 
        this.data = val; 
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public T getData() { 
        return data; 
    }

    public void setData(T data) { 
        this.data = data; 
    }

    public Node<T> getLeft() { 
        return left; 
    }

    public void setLeft(Node<T> next) { 
        this.left = next; 
    }

    public Node<T> getRight() { 
        return right; 
    }

    public void setRight(Node<T> right) { 
        this.right = right; 
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
    
}
