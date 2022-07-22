package heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int[] scoville= {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(T.solution(scoville, K));

    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int sco : scoville){
            heap.add(sco);
        }

        while(!heap.isEmpty()) {
            int a = heap.poll();
            if( a >= K) return answer;
            if( heap.isEmpty() ) return -1;
            int b = heap.poll();

            heap.add(a+b*2); // 한번 섞어주기
            answer++;
        }

        return -1;
    }
}
