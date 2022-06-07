package dfs.basic;

import java.util.Scanner;

public class Main {

    static int[] memo ;
    public int DFS(int n){
        if( memo[n] > 0) return memo[n] ;
        if(n == 1) return memo[1] = 1;
        else if(n==2) return memo[2] =1;
        else return (memo[n] = DFS(n-2) + DFS(n-1));
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        memo = new int[k];
        for(int n = 1; n< k ; n++) {
            System.out.print(T.DFS(n) + " ");
        }
    }
}
