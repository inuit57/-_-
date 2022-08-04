package heap.최대힙;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2) -> Math.abs(o1) == Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2)
        );

        int N = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i =0  ; i< N ; i++){
            int cmd = in.nextInt();
            if(cmd == 0){
                if(pq.isEmpty()){
                    sb.append(0);
                }else{
                    sb.append(pq.poll());
                }
                sb.append("\n");
            }else{
                pq.add(cmd);
            }

        }
        System.out.println(sb);
    }
}
