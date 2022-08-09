package DP.다익스트라.bj1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityNum = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());

        int[][] map = new int[cityNum][cityNum];

        Arrays.fill(map, Integer.MAX_VALUE);
        for(int i=0; i< cityNum ; i++){
            map[i][i] = 0;
        }

        ArrayList<ArrayList<Node>> board = new ArrayList<>();

        for(int i=0; i< busNum; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken()) -1;
            int end = Integer.parseInt(st.nextToken()) -1;
            int weight = Integer.parseInt(st.nextToken()) ;
            map[start][end] = weight ;
            map[end][start] = weight ;

            board.get(start).add(new Node(end,weight));
            board.get(end).add(new Node(start,weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int startPoint = Integer.parseInt(st.nextToken()) -1;
        int endPoint = Integer.parseInt(st.nextToken()) -1;


        dijkstra(cityNum, startPoint);
    }

    // https://codingnojam.tistory.com/46
    // 여기 글을 좀 참고해서 만들어보자.
    private static void dijkstra(int cityNum, int startPoint) {
        int[] dist = new int[cityNum];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startPoint] = 0;

        for(int a = 0; a < cityNum -1; a++){
            int min = Integer.MAX_VALUE;
            int min_idx = -1;

            // 노드 최솟값 찾기
            for(int i = 0; i< cityNum; i++){

            }
        }
    }

    static class Node{
        int index;
        int distance ;

        Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
    }


}
