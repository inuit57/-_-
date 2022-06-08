package dfs.subSet;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n ;
    static int[] ch;
    public void DFS(int L){
        if(L == n+1){
            for(int i =1; i<= n; i++){
                if(ch[i] == 1) System.out.print(i+" ");
            }
            System.out.println();
        }else{
            ch[L] = 1; // 체크하는 배열
            DFS(L+1);
            ch[L] = 0 ;
            DFS(L+1);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt() ;
        ch = new int[n+1] ;
        T.DFS(1);

    }
}
