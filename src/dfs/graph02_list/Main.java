package dfs.graph02_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n,m, answer =0 ;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] chk ;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        for(int i =0 ; i< n ; i++ ){
            graph.add(new ArrayList<>());
        }
        chk = new int[n+1];

        for(int i=0 ;i < m ;i++){
            graph.get(in.nextInt()).add(in.nextInt());
        }
        chk[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }

    private void DFS(int v) {
        if( v == n) answer++;
        else{
            for(int nv : graph.get(v)){
                // 갈 수 있는 정점은 다 들어있으니까
                // foreach 문을 사용하면 한번에 다 돌 수 있다.
                if( chk[nv] == 0){
                    chk[nv] = 1;
                    DFS(nv);
                    chk[nv] = 0;
                }
            }
        }
    }
}
