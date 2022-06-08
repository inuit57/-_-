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

    static int dis2[];

    /**
     * 최소거리 저장용 배열 사용 방식
     * 
     * @param v : 탐색 시작 정점
     */
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

    /**
     * 트리 순회 방식 ( level 사용 ) 
     *
     * @param v : 탐색 시작 정점
     */
    private void BFS2(int v){
        int level =0 ;
        Queue<Integer> queue = new LinkedList<>();
        chk[v] = 1;
        dis2[v] = 0;
        queue.offer(v);

        while( !queue.isEmpty()){
            int size = queue.size();
            for(int i =0 ; i< size; i++){ //큐 안의 갯수만큼 순회
                int curr = queue.poll();
                dis2[curr] = level;
                // 하나씩 뽑고 자식노드들을 큐에 다시 넣는다.
                for(int nv : graph.get(curr)){
                    if( chk[nv] == 0){
                        chk[nv] = 1;
                        queue.offer(nv);
                    }
                }
            }
            level++;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        n = in.nextInt();
        m = in.nextInt();
        chk = new int[n+1];
        dis = new int[n+1];
        dis2 = new int[n+1] ;

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
