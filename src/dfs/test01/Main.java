package dfs.test01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n]  ;
        for(int i =0 ;i<n ; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(T.solution(arr,n));
    }

    private String solution(int[] arr, int n) {
        if(dfs(arr,n, 0,0) == 0) return "YES";
        else return "NO";
    }

    private int dfs( int[] arr, int n , int sum1, int sum2 ){
        if( n == 0 ) {
            return (sum1 - sum2) ;
        }

        // sum1 에 넣는 경우
        int answer = dfs(arr, n-1, sum1 + arr[n-1], sum2);

        // sum2 에 넣는 경우
        int answer2 = dfs(arr, n-1 , sum1 , sum2+arr[n-1] );

        if( (answer == 0) || (answer2 == 0) ) return  0;
        else return -1;
    }
}
