package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] arr = new int[100001] ;
    public static void makePrimeArr(int n){
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2 ; i <= Math.sqrt((double)n) ; i++){
            int chk = i+i;
            while(chk <= n){
                arr[chk] = 1;
                chk += i ;
            }
        }
    }

    public static boolean isPrime(int n){
        return (arr[n]==0) ;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        makePrimeArr(100000);

        int n = in.nextInt();
        for(int i = 0 ; i< n; i++){
            String num = in.next();
            String tmp = new StringBuilder(num).reverse().toString();
            int numI = Integer.valueOf(tmp);

            if(isPrime(numI)){
                System.out.print(numI+" ");
            }
        }

    }
}


