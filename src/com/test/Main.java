package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int[] solution(String str,char ch){

        ArrayList<Integer> answer = new ArrayList<>();

        int idx = 0;
        idx = str.indexOf(ch);
        for(int i =0 ; i < idx ; i++){
            answer.add(idx - i);
        }
        answer.add(0);
        str = str.substring(idx+1);

        while( (idx = str.indexOf(ch)) >= 0){
            for(int i =0 ; i < idx ; i++){
                answer.add( Integer.min(i+1, idx - i));
            }
            answer.add(0);
            str = str.substring(idx+1);
        }

        if( !str.isEmpty()){
            for(int i = 1 ; i<= str.length() ; i++){
                answer.add(i);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
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


