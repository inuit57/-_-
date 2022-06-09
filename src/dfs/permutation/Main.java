package dfs.permutation;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static boolean[] visit ;
    static int[] resultArray ;
    static int n ;
    static int f ;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        n = in.nextInt();
        f = in.nextInt();

        visit = new boolean[n];
        resultArray = new int[n];


        T.DFS(0 ); // nPn
    }

    private int calculate(int[] arr){
        int len = arr.length;
        int[] arr2 = arr.clone();
        int[] result = new int[len];
        while(len >1) {
            for (int i = 0; i < len - 1; i++) {
                result[i] = arr2[i] + arr2[i + 1];
            }
            arr2 = result.clone();
            len--;
        }
        return result[0];
    }

    private void DFS(int depth) {
        if (depth == n) {
            if( calculate(resultArray) == f){
                for(int x : resultArray){
                    System.out.print(x + " ");
                }
                f = -1; // 최초 1번만 출력
            }
            return;
        }
        for(int i =0 ; i< n ;i++){
            if (!visit[i]) {
                visit[i] = true;
                resultArray[depth] = i+1;
                DFS(depth + 1);
                visit[i] = false;
            }
        }
    }
}
