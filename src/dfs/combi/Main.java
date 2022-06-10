package dfs.combi;

import java.util.Scanner;

public class Main {

    static int n ;
    static int r ;

    static boolean[] chk ;
    static int[] arr ;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        r = in.nextInt();
        chk = new boolean[n];
        arr = new int[n];

        for(int i=0 ; i<n; i++){
            arr[i] = in.nextInt();
        }

        T.DFS(0,0);


    }

    private void DFS(int L, int cnt) {
        // r 개만큼 뽑았다면 출력해주기
        if(cnt == r){
            for(int i=0 ; i< n ;i++){
                if(chk[i]){
                    System.out.print(i+1 + " ");
                }
            }
            System.out.println();
            return;
        }else if( L < n &&  !chk[L] ){
            chk[L] = true;
            DFS(L+1,cnt+1); // 선택된 경우
            chk[L] = false; //backtracking
            DFS(L+1,cnt) ; // 선택하지 않은 경우
        }
    }
}
