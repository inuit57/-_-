package com.test;

import java.util.*;

public class Main {


    public static void main(String[] args){
        Main T = new Main();
        Scanner in=new Scanner(System.in);

        String str = in.next();

        System.out.println(T.solution(str));

    }

    private int solution(String str) {

        Stack<Character> stack = new Stack<>();

        int answer = 0 ;

        for(char ch : str.toCharArray()) {
            if(ch == '('){
                stack.push(ch);
            }else if(ch == ')'){
                if(stack.peek() =='('){ // 레이저 판단
                    stack.pop();
                    if( !stack.isEmpty()) {
                        stack.push('!'); // 레이저 표시
                    }
                }else{
                    int cnt = 0 ;
                    while(stack.peek() != '('){
                        if( stack.pop() == '!'){
                            cnt ++;
                        }
                    }
                    stack.pop(); // '(' pop.
                    answer += (cnt+1);
                    if(!stack.isEmpty()) {
                        for (int i = 0; i < cnt; i++) {
                            stack.push('!');
                        }
                    }
                }
            }
        }

        return answer;
    }

}