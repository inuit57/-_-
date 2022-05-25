package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void solution(int[][] arr , int size){
        final String result = "ABDAB" ;
        for(int i = 0 ; i< size; i++){
            System.out.println(result.charAt(2+(arr[0][i]-arr[1][i])));
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int n = in.nextInt();
        int[][] arr = new int[2][n];

        for(int i = 0 ; i < 2; i++){
            for(int j = 0 ; j< n ; j++){
                arr[i][j] = in.nextInt();
            }
        }
        solution(arr,n);


    }
}


