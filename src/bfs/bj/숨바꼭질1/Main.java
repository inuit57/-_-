package bfs.bj.숨바꼭질1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int start = in.nextInt();
        int obj = in.nextInt();

        System.out.println(T.solution(start,obj));

    }

    private int solution(int start, int obj) {
        boolean[] visit = new boolean[100001];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visit[start] = true;

        int answer = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i< size ; i++){
                int curr = queue.poll();
                if( curr == obj ) return  answer;

                int next = curr-1;
                if( next >= 0 &&  !visit[next] ){
                    queue.add(next);
                    visit[next] = true;
                }
                next = curr +1;
                if( next <= 100000 &&  !visit[next] ){
                    queue.add(next);
                    visit[next] = true;
                }
                next = curr*2 ;
                if( next <= 100000 &&  !visit[next] ){
                    queue.add(next);
                    visit[next] = true;
                }
            }
            answer++;
        }

        return -1; // 도달 불가능.
    }

}
