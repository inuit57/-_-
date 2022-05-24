package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String solution(String str,int n){
        String answer ="";

        str = str.replaceAll("\\#","1");
        str = str.replaceAll("\\*","0");

        //System.out.println("str = " + str);
        for(int i = 0 ; i < n ; i++){
            int idx = 7*i ;
            String sub = str.substring(idx,idx+7);
            answer += (char)Integer.parseInt(sub,2);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int n = in.nextInt();
        String inputStr = in.next();

        System.out.println(solution(inputStr,n));
    }
}


