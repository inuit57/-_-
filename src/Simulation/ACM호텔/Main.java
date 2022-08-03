package Simulation.ACM호텔;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int T = in.nextInt(); // 테스트 케이스 갯수
        for(int i =0 ; i< T; i++){
            int H = in.nextInt(); // 층수
            int W = in.nextInt(); // 방수
            int N = in.nextInt(); // 몇 번째 손님

            int h = N%H ;
            if( h == 0) h = H;
            sb.append(h);
            int answer = N/H + 1;
            if( answer < 10) sb.append(0);
            sb.append(answer);
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
