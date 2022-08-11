package stack.bj오큰수;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    // 문제 : https://www.acmicpc.net/problem/17298
    // 풀이 참고 : https://st-lab.tistory.com/182?category=894959
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        Stack<Integer> stk = new Stack<>();
        int n = in.nextInt();

        int[] arr = new int[n];
        for(int i=0; i< n ; i++){
            arr[i] = in.nextInt();
        }

        for(int i=0; i< n ; i++){
            while( !stk.isEmpty() && arr[stk.peek()] < arr[i]){
                arr[stk.pop()] = arr[i];
            }
            stk.push(i); // 스택에는 큰 숫자만 들어가도록 처리
        }

        while(!stk.isEmpty()){
            arr[stk.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i< n; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);


    }

}
