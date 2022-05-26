package com.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int n = in.nextInt();
        int[][] arr = new int[n][n] ;

        for(int i = 0 ; i < n ; i++){
            for(int j= 0 ; j< n ; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(arr));

    }

    private static int solution(int[][] arr) {
        int max = -1;
        int size = arr[0].length;
        for (int i = 0; i < size; i++) {
            int sum0 = 0;
            int sum1 = 0;
            for (int j = 0; j < size; j++) {
                sum0 += arr[i][j]; // 가로줄 합
                sum1 += arr[j][i]; // 세로줄 합
            }
            if (max < Math.max(sum0, sum1)) {
                max = Math.max(sum0, sum1);
            }
        }

        int sum = 0;
        int sum2 = 0 ;
        for (int i = 0; i < size; i++) {
            sum += arr[i][i]; // 대각선
            sum2 += arr[size-i-1][size-i-1] ;
        }
        if (max < Math.max(sum,sum2)) {
            max = Math.max(sum,sum2);
        }


        return  max;
    }



}


