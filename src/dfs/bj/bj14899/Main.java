package dfs.bj.bj14899;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static boolean[] check  ;
    static int[][] arr ;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int n = in.nextInt();
        check = new boolean[n];
        arr = new int[n][n];

        for(int i =0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                arr[i][j] = in.nextInt();
            }
        }

        T.dfs(0,0,n);

        System.out.println(answer);

    }

    /**
     * DFS 백트래킹 만들어서 돌리기
     * @param curr 현재 선택된 값
     * @param cnt 현재 선택된 갯수 
     * @param n 배열 총 크기
     */
    private void dfs(int curr, int cnt, int n) {

        if( cnt == n/2){
            // 결과값 계산
            answer = Math.min(answer, calculate(n));
        }

        if( curr >= n ) return;
        check[curr] = true;
        dfs(curr+1,cnt+1,n); // 선택하고 진행하기
        check[curr] = false;
        dfs( curr+1, cnt , n);  // 선택 안 하고 진행하기
    }

    private int calculate(int n ){
        // check 배열로 나뉜 그룹들의 합산을 계산한다.
        // 우선은 그룹을 나누자.

        ArrayList<Integer> groupA = new ArrayList<>();
        ArrayList<Integer> groupB = new ArrayList<>();

        for(int i =0 ; i< n ; i++){
            if( check[i] ) groupA.add(i);
            else groupB.add(i);
        }

        int sumA = 0 ;
        int sumB = 0 ;
        for(int i =0 ; i < n/2 ; i++){
            for(int j= i+1; j < n/2 ; j++){
                int ai = groupA.get(i);
                int aj = groupA.get(j);

                sumA += (arr[ai][aj] + arr[aj][ai]);

                int bi = groupB.get(i);
                int bj = groupB.get(j);
                sumB += (arr[bi][bj] + arr[bj][bi]);
            }
        }
        return Math.abs(sumA-sumB);
    }

}
