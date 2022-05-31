package com.test;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

    public static void main(String[] args){
        Main T = new Main();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt(); //
        int k = in.nextInt(); // 연속된 길이

        int[] arr = new int[n];
        for(int i =0 ; i < n ; i++){
            arr[i] = in.nextInt();
        }

        boolean[] chosen = new boolean[n];
        combination_DFS(arr,chosen, 0, n,k ,0 );

        System.out.println(treeSet.stream().collect(Collectors.toList()).get(k-1));
        //System.out.println(T.solution(n,k,arr));
    }

    // DFS 방식 조합 탐색
    static void combination_DFS(int[] arr, boolean[] chosen , int start ,int n,  int r, int sum ){
        if( r== 0){
            treeSet.add(sum);
            return;
        }
        if( start == n){
            return;
        }
        // start 번째를 선택한 경우
        chosen[start] = true;
        combination_DFS(arr, chosen, start+1, n, r-1, sum+arr[start]);

        // start 번째를 선택하지 않은 경우
        chosen[start] = false;
        combination_DFS(arr, chosen, start+1, n, r, sum);
    }


    private int solution(int n, int k, int[] arr) {
        // 조합 공식 : n!/(n-3)!*3!
        int max_no = (n*(n-1)*(n-2))/6;
        if( k > max_no) return -1;

        int answer = 0 ;
        // 저장될 때 내림차순으로 저장된다.
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());

        // 무식하게 3중 포문으로 3개 모두 뽑아내자.
        // 3개 뽑는 데에는 이게 가장 효율적인 방법일까?
        for(int i =0 ; i < n ; i++){
            for(int j= i+1 ; j<n; j++){
                for(int l = j+1 ; l< n ;l++){
                    Tset.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }

        answer = Tset.stream().collect(Collectors.toList()).get(k-1);
        return answer;
    }

}