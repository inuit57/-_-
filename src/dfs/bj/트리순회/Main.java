package dfs.bj.트리순회;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        char value;
        Node left;
        Node right;
        public Node(char value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public void insertNode(char parent, char left, char right){
            if( this.value == parent){
                this.left = (left == '.'? null : new Node(left,null,null));
                this.right = (right == '.'? null : new Node(right,null,null));
            }else{
                if(this.left != null){
                    this.left.insertNode(parent, left,right);
                }
                if(this.right != null){
                    this.right.insertNode(parent,left,right);
                }
            }
        }



    }

    public static void preOrder(Node node, StringBuilder sb){
        if( node == null) return ;
        sb.append(node.value); // 계속 더해간다.
        preOrder(node.left,sb);
        preOrder(node.right,sb);
    }

    public static void inOrder(Node node, StringBuilder sb){
        if( node == null) return;
        inOrder(node.left, sb);
        sb.append(node.value);
        inOrder(node.right,sb);
    }

    public static void postOrder(Node node, StringBuilder sb){
        if( node == null) return;
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.value);
    }

    static Node tree = new Node('A',null,null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for(int i =0; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.insertNode(parent,left,right);
        }

        StringBuilder sb = new StringBuilder();
        preOrder(tree,sb);
        System.out.println(sb);

        sb = new StringBuilder();
        inOrder(tree,sb);
        System.out.println(sb);

        sb = new StringBuilder();
        postOrder(tree,sb);
        System.out.println(sb);
    }


}
