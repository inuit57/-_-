package com.test;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt(); // 전체 숫자

        int k = in.nextInt(); // 바꿀 수 있는 0의 갯수

        int[] arr = new int[n];
        for(int i=0 ; i< n; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n,k,arr) );

    }

    private static int solution(int n, int k, int[] arr) {

        int lt, cnt ,answer ;
        lt = cnt = answer = 0 ;

        for(int rt = 0 ; rt < n  ; rt++) {
            if( arr[rt] == 0) cnt ++;
            while (cnt > k){
                if( arr[lt] == 0) cnt --;
                lt ++;
            }
            answer = Math.max(answer, (rt - lt +1)) ;
        }
        return answer ;
    }
}