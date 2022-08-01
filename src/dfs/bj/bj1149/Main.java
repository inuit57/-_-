package dfs.bj.bj1149;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1149
 *
 */

// 시간 초과가 나온다. 더 빠른 방법이 필요.
    // 값을 기록하는 쪽으로 접근해보자.
public class Main {

    static int N ;
    static int[][] arr ;

    static int[][] minValues ;
    static int answer = Integer.MAX_VALUE ;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        N = in.nextInt();
        arr = new int[N][3];
        minValues = new int[N][3];

        for(int i =0 ; i< N ; i++){
            for(int j=0; j< 3; j++){
                arr[i][j] = in.nextInt();
                minValues[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i< 3; i++){
            dfs(1, arr[0][i], i);
        }

//        System.out.println(answer);

        System.out.println(T.fillValues());

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


    // 어떻게 값들을 채워나갈 수 있을까
    private int fillValues(    ){

        for(int i=0; i< 3; i++){
            minValues[0][i] = arr[0][i];
        }

        for(int i=1; i< N; i++){
            for(int j=0; j< 3; j++){
                for(int k=0; k< 3; k++){
                    if( j != k ){
                        minValues[i][j] = Math.min(minValues[i][j], minValues[i-1][k]+arr[i][j]);
                    }
                }
            }
        }

       return Arrays.stream(minValues[N-1]).min().getAsInt();
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

}
