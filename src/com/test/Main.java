package com.test;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt(); // 전체 숫자

        int k = in.nextInt(); // 연속된 일 수

        int[] arr = new int[n];
        for(int i=0 ; i< n; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n,k,arr) );

    }

    private static int solution(int n, int k, int[] arr) {

        int stt = 0 ;
        int end = k-1 ;
        int max = -1 ;

        int start = 0;
        for(int i=0; i < k ; i++){
            start += arr[i] ;
        }
        if( n == k ) {
            return start ;
        }

        int before = start ;
        max = start;

        while( end < n-1 ){
            end ++;
            int next = before + arr[end] - arr[stt];
            stt++;
            if( next > max){
                max = next ;
            }
            before = next;
        }

        return max ;
    }


}





