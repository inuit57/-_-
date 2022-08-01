package dfs.bj.bj1149;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1149
 *
 */

public class Main {

    static int N ;
    static int[][] arr ;

    static boolean[][] check ;
    static int answer = Integer.MAX_VALUE ;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        N = in.nextInt();
        arr = new int[N][3];
        check = new boolean[N][3] ;

        for(int i =0 ; i< N ; i++){
            for(int j=0; j< 3; j++){
                arr[i][j] = in.nextInt();
            }
        }

        for(int i = 0; i< 3; i++){
            dfs(1, arr[0][i], i);
        }

        System.out.println(answer);

        //T.solution();
    }

    private static void printArr() {
        for(int i =0 ; i< N ; i++){
            for(int j=0; j< 3; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int curr , int sum , int before){
        if( curr == N){
            //  결과 값 연산
            answer = Math.min(answer,sum);
            return;
        }

        for(int i=0; i< 3; i++){
            if( i == before) continue;
            int choose = arr[curr][i];
            dfs(curr+1, sum + choose , i );
        }
    }

    public void solution(){

    }
}
