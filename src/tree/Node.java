package tree;

public class Node<T> {
    private T element ;
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;

    public Node(T element){
        this.element = element;
        this.parent = null;
        this.left = null ;
        this.right = null;
    }

    Node(T element, Node<T> left , Node<T> right){
        this.element = element;
        this.parent = null;
        this.left = left;
        this.right = right;
    }

    public Node<T> getParent() {
        return parent;
    }

    Node<T> setParent(Node<T> parent){
        this.parent = parent;
        return this;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
