package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int[] solution(String str,char ch){
        int[] answer = new int[str.length()] ;
        int p = 1000 ;
        for(int i =0 ; i< str.length() ; i++){
            if (str.charAt(i) == ch) {
                p = 0 ;
            }else{
                p++;
            }
            answer[i] = p ;
        }
        for(int i = str.length()-1 ; i >=0 ; i--){
            if (str.charAt(i) == ch) {
                p = 0 ;
            }else{
                p++;
            }
            answer[i] =  Integer.min(p, answer[i])  ;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        String inputStr = in.next();
        char ch = in.next().charAt(0);

        int[] arr01 = solution(inputStr,ch);
        for (int i : arr01) {
            System.out.print(i+" ");
        }
    }
}


