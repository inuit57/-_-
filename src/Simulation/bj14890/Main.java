package Simulation.bj14890;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int L = in.nextInt();

        // 값 저장
        int[][] map = new int[N][N];
        makeMap(in, N, map);

        int answer= 0;
        for(int i =0 ; i< N ; i++){

            int row_cnt = 1;
            int col_cnt = 1;

            boolean row_flag = true;
            boolean col_flag = true;

//            int direction = -1 ; // 0 : 내리막, 1 : 오르막
            // 내리막 + 오르막이 된다면 그거는 불가능으로 취급한다.
            // 다리를 중복으로 놓는 것을 방지하자.

            for(int j=1; j< N ; j++){
                int h = map[i][j-1] - map[i][j];
                if( h == 0 ){
                    row_cnt ++;
                    // 바로 전에 있는 항목과 같다면 +1
                }else{
                    // 높이 차이가 1보다 크다면
                    if( Math.abs(h) > 1){
                        row_flag = false;
                        break;
                    }else if( h < 0) {   // 오르막을 만나는 경우
                        if (row_cnt >= L ) {
                            row_cnt = 1;
                        } else {
                            row_flag = false;
                            break;
                        }
                    }else{  // 내리막을 만나는 경우
                        row_cnt = 1;
                        j++; // 한칸 앞으로 증가.
                        for(; j< N; j++){
                            if( map[i][j-1] == map[i][j]){
                                row_cnt ++;
                            }else {
                                break;
                            }
                        }
                        if(row_cnt < L ){
                            row_flag = false;
                            break;
                        }
                    }
                }
            }
            if( row_flag ){
                answer ++;
//                System.out.println("map["+i+"][?]");
            }

            for(int j=1; j< N ; j++){
                int h = map[j-1][i] - map[j][i] ;
                if( h == 0 ){
                    col_cnt ++;
                    // 바로 전의 항목과 같다면 +1
                }else{
                    if( Math.abs( h ) > 1){
                        col_flag = false;
                        break;
                    }else if( h < 0) {  // 오르막
                        if (col_cnt >= L) {
                            col_cnt = 1;
                        } else {
                            col_flag = false;
                            break;
                        }
                    }else{  // 내리막 
                        col_cnt = 1;
                        j++; // 한칸 앞으로 증가.
                        for(; j< N; j++){
                            if( map[j-1][i] == map[j][i] ){
                                col_cnt ++;
                            }else {
                                break;
                            }
                        }
                        if(col_cnt < L ){
                            col_flag = false;
                            break;
                        }
                    }
                }
            }
            if( col_flag ){
                answer ++;
               // System.out.println("map[?]["+i+"]");
            }
        }

        System.out.println(answer - 1);

    }

    private static void makeMap(Scanner in, int N, int[][] map) {
        for(int i = 0; i< N; i++){
            for(int j = 0; j< N; j++){
                map[i][j] = in.nextInt();
            }
        }
    }
}
