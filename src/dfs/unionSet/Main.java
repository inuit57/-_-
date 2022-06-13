package dfs.unionSet;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    static int[] unf;
    public static int find(int v){
        if(v == unf[v] ) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if( fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        unf = new int[n+1] ;
        for(int i=1; i<= n; i++) unf[i] = i;
        for(int i=1; i<= m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            union(a,b);
        }
        int a = in.nextInt();
        int b = in.nextInt();
        int fa = find(a);
    }
}
