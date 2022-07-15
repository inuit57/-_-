package Simulation.bj14890;

import java.util.Scanner;

public class Main {


    // visit 배열을 사용해서 방문 체크를 확실하게 하는 것으로 수정해봅시다.
    // 그게 가장 확실하게 체크하는 방식이 되지 않을까 싶네요.

    // 한 줄씩 체크하도록 하고, visited[] 1차원 배열을 놓아서 처리하는 게 좋을 듯 합니다.
    // 길이가 1일 때, 되게 체크하기가 애매한 부분들이 많네요. visit 배열로 처리를 좀 돕는 편이 좋아보입니다.
    /*

    3 1
6 6 6
5 5 6
5 6 6
    답 : 5
    내 코드 : 6
-> 이거 테스트 필요.


6 1
5 3 3 4 6 6
5 4 3 4 6 6
4 3 3 4 5 5
3 3 3 4 4 4
3 3 3 3 4 4
5 3 3 4 5 5
    답 : 7
    내 코드 : 8

     */

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
                            row_cnt = 1 ;
                        } else {
                            row_flag = false;
                            break;
                        }
                    }else{  // 내리막을 만나는 경우
                        for(int k=1 ; k <= L ; k++){
                            if( (j+k < N) &&  map[i][j+k-1] == map[i][j+k]){
                                continue;
                            }else {
                                row_flag = false;
                                j=N;
                                break;
                            }
                        }
                        j+=L ;
                    }
                }
            }
            if( row_flag ){
                answer ++;
                System.out.println("map["+i+"][?]");
                System.out.println(map[i][0]);
            }

            for(int j=1; j< N ; j++){
                if( i == 4 ){
                    System.out.println("map[j][4] :" + map[j][4]);
                }
                int h = map[j-1][i] - map[j][i] ;
                if( h == 0 ){
                    col_cnt ++;
                    // 바로 전의 항목과 같다면 +1
                }else{
                    if( Math.abs( h ) > 1 ){
                        col_flag = false;
                        break;
                    }else if( h < 0) {  // 오르막
                        if (col_cnt >= L) {
                            col_cnt = 1 ;
                        } else {
                            break;
                        }
                    }else{  // 내리막

                        for(int k=1 ; k <= L ; k++){
                            if( (j+k < N) &&  map[j+k-1][i] == map[j+k][i]){
                                continue;
                            }else {
                                break;
                            }
                        }
                        j+=L ;
                    }
                }
            }
            if( col_flag ){
                answer ++;
                System.out.println("map[?]["+i+"]");
                System.out.println(map[0][i]);
            }
        }

        System.out.println(answer);

    }

    private static void makeMap(Scanner in, int N, int[][] map) {
        for(int i = 0; i< N; i++){
            for(int j = 0; j< N; j++){
                map[i][j] = in.nextInt();
            }
        }
    }
}
