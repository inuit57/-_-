package tree;

public class Tree<T> {

    private Node<T> root;
    private int size;
    public Tree(){
        this(null);
    }

    public Tree(Node<T> root){
        this.root = root;
        if(root != null){
            size =1;
        }
    }

    public int size(){ return this.size; }
    public Node<T> getRoot(){return this.root;}

    public Tree<T> setRoot(T element){
        if(root == null) size = 1;

        this.root = new Node(element);
        return this;
    }

    public Tree<T> setRoot(Node<T> node){
        if(root == null) size = 1;
        this.root = root;
        return this;
    }

    public Node<T> addLeft(Node<T> parent, Node<T> child){
        if( parent.getLeft() != null){
            return null;
        }
        size ++;
        parent.setLeft(child);
        return parent;
    }

    public Node<T> addRight(Node<T> parent, Node<T> child){
        if( parent.getRight() != null){
            return null;
        }
        size++;
        parent.setRight(child);
        return parent;
    }

}
