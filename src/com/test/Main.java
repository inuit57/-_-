package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void solution(int[][] arr , int size){

    }

    static int[] arr = new int[45];

    public static int fibo(int n){

        if( n <= 1){
            arr[n] = 1;
            return n;
        }
        if( arr[n] != 0) return arr[n] ;

        return arr[n] = fibo(n-1) + fibo(n-2) ;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int n = in.nextInt();

        fibo(n);
        for(int i =1 ; i <= n ; i++){
            System.out.print(arr[i]+" ");
        }

    }
}


