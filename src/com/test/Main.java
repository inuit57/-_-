package com.test;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt(); // 전체 숫자

        int m = in.nextInt(); // 목표값

        int[] arr = new int[n];
        for(int i=0 ; i< n; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n,m,arr) );

    }

    private static int solution(int n, int m, int[] arr) {

        int lt, rt, cnt ,sum ;
        lt = rt = cnt =  0  ;
        sum = arr[rt] ;

        while( rt < n ){
            if( sum < m){
                rt ++;
                if( rt >= n) break;
                sum += arr[rt];
            }else if( sum > m){
                sum -= arr[lt] ;
                lt ++;
            }
            if( sum == m){
                cnt ++ ;
                sum -= arr[lt] ;
                lt ++;
            }

        }


        return cnt ;
    }


}





