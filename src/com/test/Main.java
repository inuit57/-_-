package com.test;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args){
        Main T = new Main();
        Scanner in=new Scanner(System.in);

        int size = in.nextInt();  // 캐시 크기
        int n= in.nextInt(); // 작업 갯수

        int[] arr = new int[n] ; // 작업 저장용
        for(int i = 0 ; i < n ; i++){
            arr[i] = in.nextInt();
        }

        T.solution(size, n, arr);
        //System.out.println(T.solution(str));

    }

    private void solution(int size, int n , int[] arr) {

        Queue<Integer> cache = new LinkedList<>();
        for(int i =0 ; i < n ; i++){
            int curr = arr[i] ;
            if( cache.contains(curr) ){ // 매핑되는 경우
                cache.remove(curr);
                cache.offer(curr);
            }else{ // 매핑되지 않음
                if(cache.size() >= size){
                    cache.poll(); // 마지막 작업을 빼기
                }
                cache.offer(curr);
            }
            //System.out.println(i+"회차 진행중");
        }

        List<Integer> collect = cache.stream().collect(Collectors.toList());
        Collections.reverse(collect);
        for(int i =0 ; i< size; i++){
            //System.out.print(collect.get(size-i-1) + " ");
            System.out.print(collect.get(i) + " ");

        }

    }

}