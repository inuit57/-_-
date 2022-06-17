package bfs.inflean.coin01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int n = in.nextInt(); // 동전 갯수
        int[] coins = new int[n];
        for(int i =0; i < n ;i++){
            coins[i] = in.nextInt();
        }
        int m = in.nextInt();

        System.out.println(T.solution(coins,m));
    }

    private int solution(int[] coins, int m) {
        int cnt = 1 ; // 코인
        int answer = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i< coins.length; i++){
            queue.add(coins[i]); // 최초 설정
        }
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int k=0 ; k< len ; k++) {
                int curr = queue.poll();
                if (curr == m) answer = Math.min(answer, cnt);

                // 가지치기를 위해서 cnt < answer 추가
                // 더 진행하더라도 답이 될 수 없는 항목들은 제거
                if ((curr < m) && (cnt < answer) ) {
                    for (int i = 0; i < coins.length; i++) {
                        queue.add(curr + coins[i]);
                    }
                }
            }
            cnt++;
        }

        return answer;
    }


}
