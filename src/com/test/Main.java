package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String solution(String str){
        String answer = "";
        ArrayList<Character> charArr = new ArrayList<>();

        for(char ch : str.toCharArray()){
            if ( charArr.indexOf(ch) < -1 || charArr.isEmpty()){
                charArr.add(ch);
                answer += ch ;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        String inputStr = in.next();
        String solution = solution(inputStr);
        System.out.println(solution);
    }
}
