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


        ArrayList<Item> items = new ArrayList<>();
        visit = new boolean[items.size()];

        for(int i =0 ; i<n; i++){
            int weight = in.nextInt();
            int value =in.nextInt();
            if( weight > k) continue; // 무게가 초과하는 것들은 아예 빼버리자
            dp[1][weight] = value; // 초깃값 설정(1개만 들어갔을 때)
            items.add(new Item(weight,value));
        }


        // dp[n][w] = Math.max(dp[n-1][w] ,
        //                     dp[n-1][w-items[i].weight]+items[i].value)

        for(int i=2; i<=n; i++){
            for(int j=0; j<= k; j++) {
                for(int k=0; k< items.size(); k++) {
                    Item curr = items.get(k);
                    if( j < curr.weight) dp[i][j] = dp[i-1][j];
                    else {
                        int max = Math.max(dp[i - 1][j],
                                dp[i - 1][j - curr.weight] + curr.value
                        );
                        dp[i][j] = Math.max(max, dp[i][j]);
                    }
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
