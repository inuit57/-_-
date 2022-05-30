package com.test;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        //int n = in.nextInt(); // 전체 숫자

        Map<Character,Integer> map = new HashMap<>();

        String input = in.next();

        for(char x : input.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        String input2 = in.next();
        for(char x : input2.toCharArray()){
            if( !map.containsKey(x) || map.get(x) == 0){
                System.out.println("NO");
                return;
            }
            map.put(x, map.get(x)-1); // 하나씩 빼준다.
        }
        System.out.println("YES");
    }

    private static int solution(int n, int k, int[] arr) {

        int lt, cnt ,answer ;
        lt = cnt = answer = 0 ;

        for(int rt = 0 ; rt < n  ; rt++) {
            if( arr[rt] == 0) cnt ++;
            while (cnt > k){
                if( arr[lt] == 0) cnt --;
                lt ++;
            }
            answer = Math.max(answer, (rt - lt +1)) ;
        }
        return answer ;
    }
}