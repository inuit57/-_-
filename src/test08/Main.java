package test08;

import java.util.*;

public class Main {

    static class Order{
        int num ;
        int danger;

        Order(int num, int danger){
            this.num = num;
            this.danger = danger;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Order> orderQueue = new LinkedList<>();
        for(int i =0 ; i < n ; i++){
            int danger = in.nextInt() ;
            queue.offer(danger);
            orderQueue.offer(new Order(i,danger));
        }

        int k = -1;
        for(int i=0 ; i < n ;i++){
            while( queue.peek() != orderQueue.peek().danger){
                orderQueue.offer(orderQueue.poll());
            }
            queue.poll();
            k = orderQueue.poll().num;
            if( k == m){
                System.out.println(i+1);
                return;
            }
        }



        return ;
    }
}