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

        PriorityQueue<Order> test = new PriorityQueue<>(new Comparator<Order>() {

            @Override
            public int compare(Order o1, Order o2) {
                if( o1.danger == o2.danger) {
                    return o1.num - o2.num;
                }else{
                    return o2.danger - o1.danger;
                }
            }
        });

        Queue<Order> orderQueue = new LinkedList<>();
        for(int i =0 ; i < n ; i++){
            int danger = in.nextInt() ;
            queue.offer(danger);
            orderQueue.offer(new Order(i,danger));
            test.offer(new Order(i,danger));
        }


        for(int i =0 ; i < n ; i++){
            if( test.poll().num == m){
                System.out.println(i+1);
                return;
            }
        }

        return ;
    }
}