package DP.napSack;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int n = in.nextInt();
        int[] coins = new int[n];
        for(int i =0 ; i< n; i++) coins[i] = in.nextInt();

        int m = in.nextInt();
        System.out.println(T.solution( m , coins));
    }

    public int solution(int target, int[] coins){
        int[] dp = new int[target+1] ;
        dp[0] = 0;
        for(int coin : coins){
            for(int j=coin ; j<= target ; j++){
                int now = dp[ j - coin] + 1;
                if( dp[j] > now || dp[j] == 0 ) dp[j] = now;
            }
        }

        return dp[target];
    }
}
