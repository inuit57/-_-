package dfs.inflean.tree02;


import java.util.Scanner;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt = rt = null ;
    }
}

public class Main {
    Node root;
    public int DFS(int L,Node root){
        if((root.lt == null) && (root.rt == null)){
            // 좌우 양쪽 자식이 없는 말단 노드.
            return L;
        }
        return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.DFS(0,tree.root));
    }
}
