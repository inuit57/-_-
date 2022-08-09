package DP.다익스트라.bj1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int busNum, cityNum ;

    static List<List<Node>> board = new ArrayList<>();
    static int[] result ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cityNum = Integer.parseInt(br.readLine());
        busNum = Integer.parseInt(br.readLine());

        // board 초기화
        for(int i=0; i< cityNum; i++){
            board.add(new ArrayList<>());
        }


        for(int i=0; i< busNum; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken())-1 ;
            int end = Integer.parseInt(st.nextToken())-1 ;
            int weight = Integer.parseInt(st.nextToken()) ;

            board.get(start).add(new Node(end,weight));
            board.get(end).add(new Node(start,weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int startPoint = Integer.parseInt(st.nextToken()) -1;
        int endPoint = Integer.parseInt(st.nextToken()) -1;


        dijkstra(startPoint);

        for(int i=0; i< cityNum ; i++){
            System.out.println((i+1)+":" + result[i]);
        }
        System.out.println(result[endPoint]);
    }

    // https://codingnojam.tistory.com/46
    // 여기 글을 좀 참고해서 만들어보자.
    private static void dijkstra(int startPoint) {

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);

        result = new int[cityNum];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[startPoint] = 0;

        pq.offer(new Node(startPoint,0));
        while (!pq.isEmpty()){
            Node node = pq.poll();

            int currIdx = node.index;
            int currDist = node.distance;

            // 큐에서 꺼낸 거리와 최단거리 테이블의 거리를 비교.
            // 만약 꺼낸 거리가 더 크다면 굳이 방문할 필요가 없다.
            if( currDist > result[currIdx]){
                continue;
            }

            for(Node linkedNode : board.get(currIdx)){
                if(currDist + linkedNode.distance < result[linkedNode.index]) {
                    // if 문의 조건을 만족했다면 최단거리테이블의 값을 갱신합니다.
                    result[linkedNode.index] = currDist + linkedNode.distance;
                    // 갱신 된 노드를 우선순위 큐에 넣어줍니다.
                    pq.offer(new Node(linkedNode.index, result[linkedNode.index]));
                }
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
