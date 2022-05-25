package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int solution(Scanner in , int size){
        int cnt = 1 ;
        int curr = in.nextInt();
        for(int i =1 ; i < size  ; i++){
            int next = in.nextInt();
            if( next > curr){
                curr = next ;
                cnt ++ ;
            }
        }
        return cnt ;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int n = in.nextInt();
        int result = solution(in, n);
        System.out.println(result);

    }
}


