package bfs.bj.bj5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // 방문 체크용
    static boolean[] check = new boolean[1000001];

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int buildingsFloor = in.nextInt(); // 건물 층수
        int currFloor = in.nextInt(); // 현재 위치
        int objectFloor = in.nextInt(); // 목표 위치

        int upMove = in.nextInt();
        int downMove = in.nextInt();

        int answer = T.bfs(buildingsFloor, currFloor, objectFloor, upMove, downMove);
        if( answer < 0) System.out.println("use the stairs");
        else System.out.println(answer);
    }

    public int bfs(int limit, int curr, int obj , int up, int down  ){
        check[curr] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(curr);
        int answer = 0 ;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i =0 ; i< size ; i++){
                Integer q = queue.poll();
                if( q == null) return -1;

                int cf = q  ;
                if( cf == obj) return answer;

                int upMove = cf + up ;
                int downMove = cf - down;
                if( upMove <= limit && !check[upMove]){
                    check[upMove] = true;
                    queue.offer(upMove);
                }
                if( downMove >= 1 && !check[downMove]){
                    check[downMove] = true;
                    queue.offer(downMove);
                }
            }
            answer++;
        }

        return -1;
    }

}
