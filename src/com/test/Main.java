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
        Map<Character,Integer> map2 = new HashMap<>();
        for(char x : input2.toCharArray()){
            map2.put(x, map2.getOrDefault(x,0)+1);
        }

        for(char key : map.keySet()){
            if( map.getOrDefault(key,0) !=
                    map2.get(key)){
                System.out.println("NO");
                return;
            }
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