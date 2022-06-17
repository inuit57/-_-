package stk_queue.bj10799;

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
        for(int i =0 ; i< str.length() ; i++){
            if( str.charAt(i) == '(') stack.push('(');
            else {
                stack.pop(); // '()'
                if( str.charAt(i-1) == '('){ // 레이저
                    answer += stack.size();
                }else{
                    answer++;  // 끄트머리 하나 붙여주기
                }
            }
        }
        return answer;
    }

}