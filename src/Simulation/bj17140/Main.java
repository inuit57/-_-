package Simulation.bj17140;

import java.util.Scanner;

public class Main {

    static int[][] arr = new int[101][101] ;
    static int row = 3;
    static int col = 3;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int r = in.nextInt();
        int c = in.nextInt();
        int k = in.nextInt();

        for(int i=0; i< 3; i++){
            for(int j=0; j<3; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int answer = solution(r,c,k);
    }

    public static int solution(int r, int c, int k ){

        for(int cnt = 0 ; cnt < 100 ; cnt ++) {
            if (arr[r][c] == k) return cnt;
        }

        return -1;
    }

    // 핵심은 정렬을 어떻게 할 것인가
    // 떠오르는 것들? priority Queue ?
    // 따로 객체를 만들어서 연산을 돌리는 편이 좋을 거 같은데 말이지

    // R 연산
    public static void calculateR( ){

//        for(int i =0 ; i< 100 ; i++){
//
//        }
    }

    // C 연산
    public static void calculateC( ){

//        for(int i =0 ; i< 100 ; i++){
//
//        }
    }

}
