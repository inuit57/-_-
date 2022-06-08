package bfs.graph01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n,m,answer;
    static int[] chk ;

    // graph 정보 저장
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    // 1번에서 각 정점까지의  최소 거리를 저장
    static int dis[] ;

    private void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        chk[v] = 1;
        dis[v] = 0;
        queue.offer(v);
        while( !queue.isEmpty()){
            int curr = queue.poll();
            for(int nv : graph.get(curr)){
                if( chk[nv] == 0){
                    chk[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[curr]+1; // 이전 위치값 + 1
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        n = in.nextInt();
        m = in.nextInt();
        chk = new int[n+1];
        dis = new int[n+1];


        for(int i=0 ; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i =0 ; i<m ;i++){
            graph.get(in.nextInt()).add(in.nextInt());
        }

        T.BFS(1);
        for(int i = 2 ; i<= n ; i++){
            System.out.println(i + " : " + dis[i]);
        }
    }
}
