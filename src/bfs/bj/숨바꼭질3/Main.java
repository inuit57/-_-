package bfs.bj.숨바꼭질3;

import java.util.*;

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

        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(start);
        visit[start] = false;

        int answer = 0;
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i =0 ; i < size; i++){
                int curr = deque.pollFirst();
                if( curr == obj ){
                    return answer;
                }

                int next = curr*2 ;
                if( next <= 100000 &&  !visit[next] ){
//                    queue.add(next);
                    deque.addFirst(next);
                    visit[next] = true;
                    i--;
                }

                next = curr +1;
                if( next <= 100000 &&  !visit[next] ){
                    deque.addLast(next);
                    visit[next] = true;
                }

                next = curr-1;
                if( next >= 0 &&  !visit[next]  ){
                    deque.addLast(next);
                    visit[next] = true;
                }
            }
            answer++;
        }

        return -1; // 도달 불가능.
    }

}
