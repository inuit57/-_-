package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String solution(String str){
        String answer ="";

        str += " "; // 0, 0+1 하는 식으로 비교하기 위해서
        int cnt = 1;
        for (int i =0 ; i < str.length()-1 ; i++ ){
            if(str.charAt(i) != str.charAt(i+1)){
                answer += str.charAt(i);
                if( cnt >1 ) {answer += cnt;}
                cnt = 1;
            }else{
                cnt ++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        String inputStr = in.nextLine();

        System.out.println(solution(inputStr));
    }
}


