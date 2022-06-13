package union_find.bj1717;

import java.util.Scanner;

public class Main {
    static int[] unf ;

    static int find(int v){
        if( unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }

    static void union(int a,int b){
        int x = find(a);
        int y = find(b);
        if( x != y ){
            unf[x] = y;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n+1]; // 집합 초기화

        for(int i=0 ; i<=n ; i++){
            unf[i] = i ;
        }


        for(int i=0 ; i< m ; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();

            if( a == 0) union(b,c);
            else{
                if( find(b) == find(c)){
                    sb.append("YES\n");
                }
                else{
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }
}
