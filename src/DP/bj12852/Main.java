package DP.bj12852;

import java.util.Scanner;

public class Main {

    static int[] arr ;
    static int[] record;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int n = in.nextInt();
        arr = new int[n+1] ;
        record = new int[n+1] ;

        for(int i =1; i<= n ; i++){
            T.dp(i);
        }

        int answer = n ;
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append(" ");

        while(answer>1){
            if( answer%2 == 0 && arr[n/2] < arr[n-1]){
                answer/=2 ;
            }else if(answer%3 == 0 && arr[n/3] < arr[n-1]){
                answer/=3;
            }else{
                answer-- ;
            }
            sb.append(answer).append(" ");
        }
        System.out.println(sb);
    }

    public void dp(int num){
        // dp 채우기
        if(num <= 3 ){
            arr[num] = 1 ;
        }else if(num%6 == 0){
            arr[num] = Math.min(arr[num-1],Math.min(arr[num/3], arr[num/2]))+1;
        }else if(num%3 == 0){
            arr[num] = Math.min(arr[num/3], arr[num-1])+1 ;
        }else if(num%2 == 0){
            arr[num] = Math.min(arr[num/2] , arr[num-1])+1;
        }else{
            arr[num] = arr[num-1] + 1 ;
        }
    }
}
