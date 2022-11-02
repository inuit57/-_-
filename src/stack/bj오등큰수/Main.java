package stack.bj오등큰수;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 수열의 각 원소 갯수 저장용
        Map<Integer,Integer> map = new HashMap<>();
        // 답안 도출용 스택
        Stack<Integer> stk = new Stack<>();

        // 입력값 저장
        int n = in.nextInt();
        int[] arr = new int[n] ;
        int[] answer = new int[n]; // 답안 저장용
        for(int i=0; i< n ; i++){
            int key = in.nextInt();
            arr[i] = key;
            // 넣으면서 동시에 map에 갯수 저장
            map.put(key, map.getOrDefault(key,0)+1);
        }


        // 스택에 값 넣으면서 답안 도출하기
        // 스택에 저장되어야 하는 것은 위치 값
        for(int i=0; i<n ; i++){
            while(!stk.isEmpty() &&
                    map.get(arr[stk.peek()]) < map.get(arr[i]) ){
                answer[stk.pop()] = arr[i] ;
            }
            stk.push(i);
        }

        while(!stk.isEmpty()){
            answer[stk.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int a : answer){
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }



}
