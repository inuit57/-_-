package com.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        String inputStr = in.nextLine().replace(" ","");

        System.out.println(solution(inputStr));
    }

    private static int solution(String inputStr) {
        int score = 0 ;
        String[] results = inputStr.split("0");

        for(String str : results){
            for(int i = 1 ; i <= str.length(); i++){
                score += i ;
            }
        }

        return score;
    }
}


