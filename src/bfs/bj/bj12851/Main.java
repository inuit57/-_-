package bfs.bj.bj12851;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        if( n == k){
            System.out.println(0);
            System.out.println(1);
            return;
        }


        int cnt=0  ;  // 방법의 가짓수
        int time = 0 ;   // 시간

        boolean isFind = false ;
        boolean[] check = new boolean[100001];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty() && !isFind){
            int size = queue.size();
            for(int i=0 ; i< size ; i++){
                int curr = queue.poll();
                check[curr] = true  ;
                if( curr == k ){
                    isFind = true;
                    cnt ++ ;  // 답안 찾음
                    // 추가로 queue 에 집어넣지는 않는다.
                }
                if( curr < k && !check[curr+1] ) {
                    queue.add(curr + 1);
                }
                if( curr > 0 && !check[curr-1]) {
                    queue.add(curr - 1);
                }
                if( curr > 0 && curr <= 50000 && !check[curr*2]){
                    queue.add(curr * 2) ;
                }
            }
            time ++ ;
        }
        System.out.println(time -1 );
        System.out.println(cnt);

    }

}
