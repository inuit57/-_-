package dfs.inflean.permutation02;

import java.util.Scanner;

public class Main {

    static boolean[] visit ;
    static int[] resultArray ;
    static int n ;
    static int m ;
    static StringBuilder str = new StringBuilder();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        n = in.nextInt();
        m = in.nextInt();

        visit = new boolean[n];
        resultArray = new int[m];


        T.DFS(0 ); // nPn
        System.out.println(str);
    }

    private void DFS(int depth) {
        if (depth == m) {
            for(int x : resultArray){
                //System.out.print(x + " ");
                str.append(x);
                str.append(' ');
            }
            str.append('\n');
            return;
        }
        for(int i =0 ; i< n ;i++){
                resultArray[depth] = i+1;
                DFS(depth + 1);
        }
    }
}
