package com.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n] ;

        for(int i = 0 ; i < n ; i++){
            arr[i] = in.nextInt();
        }

        int[] result = solution(arr);
        for(int i =0 ; i< n ; i++){
            System.out.print(result[i] + " ");
        }

    }

    private static int[] solution(int[] arr) {
        int size = arr.length;
        int[] rank = new int[size] ;
        for(int i = 0 ; i < size ; i++){
            rank[i]++;
            for(int j = i+1 ; j < size ; j++){
                if( arr[j] > arr[i]){
                    rank[i]++;
                }else if(arr[j] < arr[i]){
                    rank[j]++;
                }
            }
        }
        return rank;
    }

}


