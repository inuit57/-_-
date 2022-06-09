package dfs.permutation02;

import java.util.Scanner;

public class Main {

    static boolean[] visit ;
    static int[] resultArray ;
    static int n ;
    static int m ;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        n = in.nextInt();
        m = in.nextInt();

        visit = new boolean[n];
        resultArray = new int[m];


        T.DFS(0 ); // nPn
    }

    private void DFS(int depth) {
        if (depth == m) {
            for(int x : resultArray){
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }
        for(int i =0 ; i< n ;i++){
                resultArray[depth] = i+1;
                DFS(depth + 1);
        }
    }
}
