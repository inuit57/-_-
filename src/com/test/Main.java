package com.test;

import com.sun.source.tree.Tree;

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

        for(char x : str.toCharArray()){
            if( x == ')'){
                if(stack.isEmpty()){
                    return "NO";
                }
                stack.pop();
            }else{
                stack.push(x); // '('
            }
        }
        if( !stack.isEmpty() ){
            return "NO";
        }
        return "YES" ;
    }


}