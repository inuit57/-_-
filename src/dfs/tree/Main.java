package dfs.tree;


import java.util.Scanner;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt = rt = null ;
    }
}

enum Type{
    PREFIX,INFIX,POSTFIX
}

public class Main {
    Node root;
    public void DFS(Node root,Type type){
        if(root == null) return;
        switch (type){
            case PREFIX:
                System.out.print(root.data +" ");
                DFS(root.lt,type);
                DFS(root.rt,type);
                break;
            case INFIX:
                DFS(root.lt,type);
                System.out.print(root.data +" ");
                DFS(root.rt,type);
                break;
            case POSTFIX:
                DFS(root.lt,type);
                DFS(root.rt,type);
                System.out.print(root.data +" ");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        System.out.print("PREFIX :");
        tree.DFS(tree.root,Type.PREFIX);
        System.out.println();

        System.out.print("INFIX :");
        tree.DFS(tree.root,Type.INFIX);
        System.out.println();

        System.out.print("POSTFIX :");
        tree.DFS(tree.root,Type.POSTFIX);
        System.out.println();
    }
}
