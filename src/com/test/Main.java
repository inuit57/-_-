package com.test;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt(); // 전체 숫자

        Map<Character,Integer> map = new HashMap<>();

        String vote = in.next();

        for(char x : vote.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        int max = Integer.MIN_VALUE;
        char answer = ' ';
        for (char key : map.keySet()){
            // System.out.println(x+" "+ map.get(x));
            if( max < map.get(key)){
                max = map.get(key);
                answer = key ;
            }
        }
        System.out.println(answer);
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