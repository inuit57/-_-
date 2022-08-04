package Simulation.프린터큐;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Doc{
        int idx;
        int num;

        Doc(int idx,int num){
            this.idx = idx;
            this.num = num;
        }

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        StringBuilder sb = new StringBuilder();
        int t = in.nextInt(); // 테스트 케이스 수
        for(int i =0; i< t; i++){
            int n = in.nextInt();
            int obj = in.nextInt();
            int[] arr = new int[n];
            for(int j=0; j< n ; j++){
                arr[j] = in.nextInt();
            }
            sb.append(T.solution( arr, obj ));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public int solution( int[] arr, int obj ){
        int idx = 1;

        Queue<Doc> queue = new LinkedList<>();

        for(int i =0 ; i< arr.length ; i++){
            queue.add(new Doc(i,arr[i]));
        }

        while(!queue.isEmpty()){
            Doc curr = queue.poll();

            if(queue.stream().filter(q -> q.num > curr.num ).count() > 0){
                queue.add(curr);
            }else{
                if( curr.idx == obj ) break;
                idx ++;
            }
        }
        return idx;
    }
}
