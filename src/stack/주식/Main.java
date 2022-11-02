package stack.주식;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        int[] prices = {1, 2, 3, 2, 3};

        int[] answer = m.solution(prices);
        StringBuilder sb = new StringBuilder();
        for(int a : answer){
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }

    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];

        // 좌표 값을 저장해보자
        Stack<Integer> stk = new Stack<>();

        // 1, 2, 3
        // 1, 2, 3, "2"
        // (0, 1, 2) i=3
        // answer = { 0, 0 , 1 }  // 3 - 2(top) , 조건은 top > prices[i] 다음 것보다 top 이 클 때

        // (0,1,3) 1,2,2 인 상태
        // (0,1,3,4) 1,2,2,3 끝.

        // 남은 것들은 이제 길이(4)에서 빼주면 될 듯
        // (4,3,1,1,0)
        for(int i = 0; i < length; i++){
            while(!stk.isEmpty() && prices[stk.peek()] > prices[i]){
                int top = stk.peek();
                stk.pop();
                answer[top] = (i - top);
            }
            stk.push(i);
        }

        for(int i = 0; i< length; i++){
            if( answer[i] == 0 ) answer[i] = length - i - 1;
        }

        return answer;
    }
}
