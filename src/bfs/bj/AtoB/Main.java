package bfs.bj.AtoB;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        long start = in.nextInt();
        long obj = in.nextInt();
        System.out.println(T.solution(start, obj));
    }

    /**
     * 시작값 -> 목표값, 최소횟수 + 1 을 반환
     * @param start 시작값
     * @param obj 목표값
     * @return 바뀔 수 있는 최소횟수 +1
     */
    public long solution(long start,long obj){


        Queue<Long> queue = new LinkedList<>();
        HashSet<Long> set = new HashSet<>();
        queue.add(start);
        set.add(start); // set 에 저장을 시도해보자.

        long answer = 1;
        while(!queue.isEmpty()){
            long size = queue.size();
            for(long i =0; i< size; i++){
                long curr = queue.poll(); // 한놈 뽑자

                if( curr == obj ) return answer;

                long next = curr * 2;
                if( next <= obj &&  set.add(next)){
                    queue.add(next);
                }

                next = curr*10 + 1 ;
                if( next <= obj && set.add(next) ){
                    queue.add(next);
                }

            }
            answer ++;
        } // while end
        return -1;
    }
}
