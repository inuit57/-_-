package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String solution(String str){
        String answer ="";

        int cnt = 1;
        char chk_ch = str.charAt(0);
        answer += chk_ch;
        for (int i =1 ; i < str.length() ; i++ ){
            if(str.charAt(i) != chk_ch){
                if( cnt >1 ) {answer += cnt;}
                chk_ch = str.charAt(i);
                answer += chk_ch;
                cnt = 1;
            }else{
                cnt ++;
            }
        }
        if( cnt >1 ) {answer += cnt;}

        return answer;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        String inputStr = in.nextLine();

        System.out.println(solution(inputStr));
    }
}


