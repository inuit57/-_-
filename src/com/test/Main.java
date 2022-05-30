package com.test;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt(); // 전체 숫자

        Map<Character,Integer> map = new HashMap<>();

        String vote = in.next();
        for(int i =0 ; i < vote.length() ; i++){
            Integer curr = map.get(vote.charAt(i));
            if( curr == null){
                map.put(vote.charAt(i),1);
            }else{
                map.replace(vote.charAt(i), curr+1);
            }
        }

        Set<Character> sets = map.keySet();
        int max = -1;
        char answer ='a' ;
        for(char ch : sets){
            if( map.get(ch) > max){
                max = map.get(ch);
                answer = ch ;
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