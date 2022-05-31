package com.test;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt(); //

        int k = in.nextInt(); // 연속된 길이

        int[] arr = new int[n];
        for(int i =0 ; i< n ; i++){
            arr[i] = in.nextInt();
        }
        //System.out.println(solution(n,k,arr));
        solution(n,k,arr);
    }

    private static int solution(int n, int k, int[] arr) {
        int lt =0;

        HashMap<Integer,Integer> map = new HashMap<>();
        // 최초로 값 집어넣기
        for(int i =0 ; i < k ; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        System.out.print(map.size()+" ");

        for(int rt=k ; rt < n ;rt++){
            map.put(arr[lt],
                    map.get(arr[lt])-1);
            if( map.get(arr[lt])== 0){
                map.remove(arr[lt]);
            }
            lt++;
            map.put(arr[rt],
                    map.getOrDefault(arr[rt],0)+1);
            System.out.print(map.size() + " ");
        }
        return 0;
    }
}