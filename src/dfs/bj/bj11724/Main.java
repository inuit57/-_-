package dfs.bj.bj11724;

import java.util.*;

public class Main {
    static int[] unf ;

    static int find(int v){
        if( unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }

    static void union(int a,int b){
        int x = find(a);
        int y = find(b);

        if (x < y) {
            unf[y] = x;
        }else unf[x] = y;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        unf = new int[n+1]; // 집합 초기화

        for(int i=1 ; i<=n ; i++){
            unf[i] = i ;
        }

        for(int i =0 ; i < m ;i++){
            int a = in.nextInt();
            int b = in.nextInt();

            union(a,b);
        }



        Set<Integer> set = new HashSet<>();
        for(int i =1; i <= n ; i++){
            set.add(find(i));
        }

        System.out.println(set.size());
    }

}
