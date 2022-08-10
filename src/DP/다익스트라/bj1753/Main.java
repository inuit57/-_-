package DP.다익스트라.bj1753;

import java.util.*;

public class Main {

    static int v, e;
    static List<List<Node>> graph = new ArrayList<>();

    static int[] result ;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        v = in.nextInt();
        e = in.nextInt();

        for(int i =0; i < v+1; i++){
            graph.add(new ArrayList<>());
        }

        int start = in.nextInt();

        // 간선정보 입력받기
        for(int i=0; i< e; i++){
            int stt = in.nextInt();
            int end = in.nextInt();
            int ds = in.nextInt();

            graph.get(stt).add(new Node(end,ds));
        }

        result = new int[v+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i =1 ; i< v+1; i++){
            int answer = result[i];
            if( answer == Integer.MAX_VALUE){
                sb.append("INF");
            }else{
                sb.append(answer);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.dist - o2.dist));

        pq.add(new Node(start,0));

        while(!pq.isEmpty()){

            Node curr = pq.poll();
            int currIdx = curr.index;
            int currDist = curr.dist;

            if( currDist > result[currIdx]) continue;

            for( Node n : graph.get(currIdx)){
                if( n.dist + currDist < result[n.index] ){
                    result[n.index] = n.dist + currDist;
                    pq.add(new Node(n.index, result[n.index]));
                }
            }
        }
    }

    static class Node{
        int index ;
        int dist ;

        public Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
    }
}
