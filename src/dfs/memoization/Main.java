package dfs.memoization;

import java.util.*;


public class Main {
    static int[][] memoArr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        int n = in.nextInt();
        int r = in.nextInt();

        memoArr = new int[n+1][n+1] ;
        System.out.println(T.combination(n,r));
    }

    private int combination(int n, int r) {
        if( memoArr[n][r] !=0) return memoArr[n][r];
        if( n == r || r == 0) return 1;

        return memoArr[n][r] = combination(n-1,r-1) + combination(n-1,r);
    }
}
