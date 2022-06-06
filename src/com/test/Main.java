package com.test;

import java.util.*;

public class Main {


    public static void main(String[] args){
        Main T = new Main();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i =0 ; i < n ; i++){
            arr[i] = in.nextInt();
        }

        T.solution(n,arr);
        return ;
    }

    void solution( int n , int[] arr){
        int pt = -1;
        for(int i = n-1; i >0 ; i--){
            if( arr[i] < arr[i-1]){
                pt = i ;  // 범인 찾음
                break;
            }
        }
        for(int i =0 ; i < pt ; i++){
            if( arr[i] > arr[pt]){
                System.out.print(i+1 + " ");
                break;
            }
        }
        System.out.print(pt+1);
    }


}