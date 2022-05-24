package com.test;

import java.util.Scanner;

public class Main {

    public static String solution(String strArr){

        String alphaOnly = new StringBuilder(strArr.replaceAll("[^a-zA-Z]","")).reverse().toString();

        String answer = "";
        int idx = 0 ;
        for(char ch : strArr.toCharArray()){
            if( Character.isAlphabetic(ch)){
                answer += alphaOnly.charAt(idx);
                idx++;
            }else {
                answer += ch;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        String inputStr = in.next();

        System.out.println(solution(inputStr));
    }
}
