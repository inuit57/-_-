package com.test;

import java.util.Scanner;

public class Main {

    static int[][] arr ;
    static int n ;

    static int[] px = {1,-1,0,0};
    static int[] py = {0,0,1,-1};

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        n = in.nextInt();
        arr = new int[n][n] ;

        for(int i = 0 ; i < n ; i++){
            for(int j= 0 ; j< n ; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(solution());

    }



    private static int topCheck(int x, int y , int curr){

        if( x < 0 || y < 0 || x >= n || y >= n ){
            return 1;
        }
        if( arr[x][y] >= curr) return  0;
        return 1;
    }

    private static int solution() {
        int cnt = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j =0 ; j< n ; j++){
                int isTop = 0;
                for(int k=0; k < 4; k++){
                    isTop += topCheck(i+px[k], j+py[k],arr[i][j]);
                }
                if(isTop == 4){
                    cnt ++;
                }
            }
        }
        return cnt;
    }



}


