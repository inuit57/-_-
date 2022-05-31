package com.test;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Main T = new Main();
        Scanner in=new Scanner(System.in);
        String str = in.next(); //

        String obj = in.next(); // 연속된 길이

        System.out.println(T.solution(str,obj));
    }

    private int isAnagram(Map<Character,Integer> map, String str){
        for(char ch : str.toCharArray()){
            if( !map.containsKey(ch) || (map.get(ch) <= 0)){
//                System.out.println("str FAIL : " + str);
                return 0;
            }
            map.put(ch, map.get(ch) -1) ;
        }
//        System.out.println("str PASS : " + str);
        return 1;
    }
    private int solution(String str, String obj) {
        int answer = 0 ;

        HashMap<Character,Integer> map = new HashMap<>();
        // obj 값을 맵에 집어넣기
        for(char x : obj.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        for(int lt = 0 ; lt <= str.length() - obj.length() ; lt++){
            String x = str.substring(lt, lt + obj.length());
//            System.out.println(x);
            answer += isAnagram(new HashMap<>(map), x);
        }


        return answer ;
    }

}