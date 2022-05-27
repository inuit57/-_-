package com.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int a, b;
        a = in.nextInt();
        int[] arrA = new int[a];
        for(int i =0 ; i < a; i++){
            arrA[i] = in.nextInt() ;
        }
        b = in.nextInt();
        int[] arrB = new int[b];
        for(int i=0 ; i< b; i++){
            arrB[i] = in.nextInt();
        }

        for(int ans : T.solution(a,b,arrA,arrB)){
            System.out.print(ans + " ");
        }
    }


    private int[] solution(int a, int b, int[] arrA, int[] arrB) {
        int[] answer = new int[a+b] ;
        int pa, pb , idx ;
        idx=pa=pb=0;

        while((pa < a) && (pb < b)){
            if( arrA[pa] > arrB[pb]){
                answer[idx++] = arrB[pb++];
            }else{
                answer[idx++] = arrA[pa++];
            }
        }
        
        // 남은  찌거기 제거
        if( pa >= a){
            for(int i = pb ; i< b; i++){
                answer[idx++] = arrB[i];
            }
        }
        if( pb >= b){
            for(int i = pa ; i< a; i++){
                answer[idx++] = arrA[i]; 
            }
        }
        return answer;
    }
}





