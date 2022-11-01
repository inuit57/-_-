package stack.bj1725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+2] ;
        for(int i=1; i< n+1 ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 스택에 저장하는 것은 길이가 아닌 위치 정보
        // 맨 위에 있는 것보다 다음에 들어가는 것이 크다면 push 한다.
        // 만약 작다면 맨 위의 것이 다음에 들어올 것보다 낮아질 때까지 pop 한다.

        Stack<Integer> stk = new Stack<>();
        stk.push(0); // peek() 에러 방지용

        // 의문점 : 왜 max 를 음수로 초기화하면 40%대에서 틀렸습니다로 나올까요
        int max = 0 ;


        for(int i =1 ; i <= n+1 ; i++){

            while( !stk.isEmpty() && arr[stk.peek()] > arr[i] ) {
                int check = stk.peek();
                stk.pop();
                max = Math.max(max, arr[check] * ( i - stk.peek() -1));
            }
            stk.push(i);
        }

        System.out.println(max);
    }
}
