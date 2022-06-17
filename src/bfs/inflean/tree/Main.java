package bfs.inflean.tree;


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
    public void BFS(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L=0;
        while (!queue.isEmpty()){
            int len = queue.size(); // len = 1
            System.out.print(L+" : ");
            for(int i=0; i< len; i++){
                Node x = queue.poll();
                System.out.print(x.data + " ");
                if (x.lt != null) queue.offer(x.lt);
                if (x.rt != null) queue.offer(x.rt);
            }
            L++;
            System.out.println();
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
        tree.BFS(tree.root);
    }
}
