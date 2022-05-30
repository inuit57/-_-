package com.test;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt(); // 전체 숫자

//        int m = in.nextInt(); // 목표값

//        int[] arr = new int[n];
//        for(int i=0 ; i< n; i++){
//            arr[i] = in.nextInt();
//        }

        System.out.println(solution(n) );

    }

    private static int solution(int n) {

        int lt, cnt ,sum ;
        cnt = sum =  0  ;

        lt = 1;

        // 강사님 방법은 rt를 for 문으로 돌리고
        // 그 안에서 lt를 증가시키는 방법
        // 내가 사용한 while 문의 경우 배열 밖으로 튀는 경우가 있었는데
        // 이렇게 하면 그런 경우는 없지 싶다.
        for(int rt = 1 ; rt <= (n/2)+1 ; rt++) {
            sum += rt ;
            if( sum == n ){
                cnt ++ ;
            }
            // 하나만 빼선 안될 수 있으니까 while 문을 사용한다.
            while ( sum >= n){
                sum -= lt;
                lt++;
                if( sum == n) cnt++;
                // 빼고 나서도 변경되니까 비교를 해줘야한다.
            }
        }
        return cnt ;
    }
}