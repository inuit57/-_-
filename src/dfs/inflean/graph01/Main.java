package dfs.inflean.graph01;

import java.util.Scanner;

public class Main {
    static int[][] graph;
    static int[] chk ;
    static int answer = 0 ;
    static  int n ;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        graph = new int[n+1][n+1];
        chk = new int[n+1] ;

        for(int i =0 ; i < m ; i++){
            graph[in.nextInt()][in.nextInt()] = 1;
        }
        chk[1]=1;
        T.DFS(1) ;
        System.out.println(answer);
    }

    private void DFS(int v) {
        if( v == n ){
            answer++;
        }else {
            for (int i = 0; i < n; i++) {
                if (graph[v][i] == 1 && chk[i] == 0) {
                    chk[i] = 1;
                    DFS(i);
                    chk[i] = 0; // back tracking
                }
            }
        }
    }
}
