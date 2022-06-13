package union_find.bj1976;

import java.util.Scanner;

public class Main {

    static int[] unf ;

    static int find(int v){
        if( unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }

    static void union(int a,int b){
        int fa = find(a);
        int fb = find(b) ;
        if( fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        unf = new int[n+1] ;

        int[][] arr = new int[n][n];
        for(int i=0 ; i< n; i++){
            unf[i]=i;
            for(int j= 0 ; j<n ; j++){
                arr[i][j] = in.nextInt();
            }
        }
        // 값 채워주기

        for(int i =0 ; i< n; i++){
            for(int j=0 ; j < i ; j++){
                if( arr[i][j] == 1){
                    union(i,j);
                }
            }
        }

        int[] plan = new int[m] ;
        for(int i =0 ; i  < m ; i++){
            plan[i] = in.nextInt() -1 ;
        }

        for(int i =0 ; i< m-1; i++){
            if( find(plan[i]) != find(plan[i+1])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
}
