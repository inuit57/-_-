package bfs.tree01;


import java.util.LinkedList;
import java.util.Queue;
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
    public int BFS(Node root){
        int L = 0 ;
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        while (!Q.isEmpty()){
            int len = Q.size();
            for(int i =0 ; i< len ;i++){
                Node curr = Q.poll();
                if( (curr.lt == null ) && (curr.rt == null)) return L;
                if(curr.lt != null) Q.offer(curr.lt);
                if(curr.rt != null) Q.offer(curr.rt);
            }
            L++;
        }
        return L ;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.BFS(tree.root));
    }
}
