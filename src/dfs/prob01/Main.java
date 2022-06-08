package dfs.prob01;

import java.util.Scanner;

public class Main {

    static int c,n, answer =0;
    static int[] arr ;
    static int[] chk ;

    public static void main(String[] args) {

        Main T = new Main();
        Scanner in = new Scanner(System.in);

        c = in.nextInt();
        n = in.nextInt();

        arr = new int[n];
        chk = new int[n];

        for(int i =0 ; i < n; i++){
            arr[i] = in.nextInt();
        }

        T.DFS(0);
        System.out.println(T.DFS(0,0,arr));
        System.out.println(answer);
    }

    // 강사님 풀이 + 수정
    private int DFS(int L, int sum, int[] arr){
        if(sum >= c ) return -1;
        if(L == n){
            return sum;
        }else{
            return Math.max(
                DFS(L+1, sum+arr[L] , arr),
                DFS(L+1, sum, arr)
            );

        }
    }

    private void DFS(int L) {
        if( L >= n){
            int sum =0 ;
            for(int i =0 ; i< n ; i++){
                if(chk[i]!=0){
                    sum += arr[i];
                    if( sum >= c) return; // 가지치기
                }
            }
            if(sum < c){
                answer = Math.max(sum,answer);
            }
        }else{
            chk[L] = 1;
            DFS(L+1);
            chk[L] = 0;
            DFS(L+1);
        }
    }
}
