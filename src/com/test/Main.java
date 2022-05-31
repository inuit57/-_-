package com.test;

import java.util.*;

public class Main {


    public static void main(String[] args){
        Main T = new Main();
        Scanner in=new Scanner(System.in);

        String str = in.next();  // 괄호 문자열

        System.out.println(T.solution(str));
    }

    private String solution(String str) {
        Stack<Character> stack = new Stack<>();
        String answer ="";

        for(char x : str.toCharArray()){
            if( x == ')'){
                stack.pop();
            }else if(x == '('){
                stack.push(x); // '('
            }else{  //알파벳
                if(stack.isEmpty()){
                    answer += x; // 붙여주기
                }
                // push 도 해줄 필요가 없지 싶다.
            }
        }
        return answer;
    }


}