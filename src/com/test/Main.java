package com.test;

import java.util.*;

public class Main {


    public static void main(String[] args){
        Main T = new Main();
        Scanner in=new Scanner(System.in);

        String str = in.next();

        System.out.println((int)T.solution(str));

    }

    private double calculate(double a, double b, char op){
        switch (op){
            case '+' : return b+a;
            case '-' : return b-a;
            case '*' : return b*a;
            case '/' : return b/a;
        }
        return 0;
    }

    private double solution(String str) {
        double answer = 0;
        Stack<Double> stk = new Stack<>();
        for(char ch : str.toCharArray()){
            if( Character.isDigit(ch)){
                stk.push((double)(ch-'0'));
            }else{
                //answer = calculate(stk.pop()-'0',stk.peek()-'0',ch);
                answer = calculate(stk.pop(),stk.pop(),ch);
                stk.push(answer);
            }
        }

        answer = stk.pop();

        return answer;
    }

}