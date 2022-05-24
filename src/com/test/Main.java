package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String[] solution(String[] strArr){

        ArrayList<String> answer = new ArrayList<>();

        for(String str : strArr ){
            String s = new StringBuilder(str).reverse().toString();
            answer.add(s);
        }
        return answer.toArray(new String[answer.size()]);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int n = in.nextInt();
        String[] strArr = new String[n];
        for(int i=0 ; i<n; i++){
            String str = in.next();
            strArr[i] = str;
           // System.out.println(i+":" + strArr[i]);
        }
        for(String s : solution(strArr)){
            System.out.println(s);
        }

        return;
    }
}
