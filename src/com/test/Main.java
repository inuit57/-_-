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

        int answer , sum =0 ;
        // 첫번째 윈도우 생성
        for(int i =0 ; i< k ; i++) sum +=arr[i] ;
        answer = sum;

        for(int i =k ; i< n ; i++){
            sum += (arr[i] - arr[i-k]);
            answer = Math.max(answer,sum);
        }
        return answer ;
    }


}





