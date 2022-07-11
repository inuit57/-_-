package stack.bj2812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputs = br.readLine();
        String[] s = inputs.split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]) + 1;

        String number = br.readLine();
        Stack<Integer> stk = new Stack<>();

        stk.push(0);

        // 반례
        // 5 2
        // 88892 -> 내가 찾은 답 : 888
        // 원하는 답 : 892

        // 여러 번 앞에서 뺄 수도 있다는 것을 생각했어야 했었다.
        // 스택으로 풀면 되는 문제인데, 왜 Dequeue 를 사용한걸까? 겁쟁이들.
        int max = -1;
        for(int ch : number.toCharArray()){
            ch-='0';

            while(k > 0 && !stk.isEmpty() && stk.peek() < ch ){
                stk.pop();
                k--;
            }
            stk.push(ch);
        }

        for(int i =0 ; i < k ; i++){
            stk.pop(); // 끝에 남은 찌꺼기들 처리
        }

        StringBuilder sb = new StringBuilder();
        for (int curr : stk) {
            sb.append(curr);
        }
        System.out.println(sb);

    }
}
