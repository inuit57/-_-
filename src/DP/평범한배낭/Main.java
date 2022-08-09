package DP.평범한배낭;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n, k;

    static int[][] dp;
    static boolean[] visit ;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        k = in.nextInt();
        dp = new int[n+1][k+1] ;


        Item[] items = new Item[n+1];

        for(int i =1 ; i<=n; i++){
            int weight = in.nextInt();
            int value =in.nextInt();
            items[i] = new Item(weight,value);
        }


        // dp[n][w] = Math.max(dp[n-1][w] ,
        //                     dp[n-1][w-items[i].weight]+items[i].value)

        // 가능한 무게에 대해서 모든 항목을
        // 한 번씩 집어넣는 식으로 처리하는 것이 답이 되었네요.
        for(int i=1; i<=n; i++){
            for(int j=1; j<= k; j++) {
                if( j >= items[i].weight){
                    dp[i][j] = Math.max(dp[i-1][j],
                            dp[i-1][j-items[i].weight]+items[i].value);
                }else{
                    dp[i][j] = dp[i-1][j] ;
                }
            }
        }

        System.out.println(dp[n][k]);

    }



    static class Item{
        int weight;
        int value;
        public Item(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }
}
