package Simulation.bj15638;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final int WALL = 6;
    public static final int CCTV01 = 1;
    static int[] px = {1,0,-1,0};
    static int[] py = {0,1,0,-1};

    static int row;
    static int col;
    static int[][] board;

    static class Point{
        int x, y;
        int cctvNo ;

        Point(int x,int y, int cctvNo){
            this.x = x;
            this.y = y;
            this.cctvNo = cctvNo;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        row = in.nextInt();
        col = in.nextInt();

        board = new int[row][col];

        List<Point> pList = new ArrayList<>();

        for(int i = 0 ; i < row ; i++){
            for(int j=0 ; j< col ; j++){
                int curr = in.nextInt();
                board[i][j] = curr;
                if( 0< curr && curr < 6){
                    pList.add(new Point(i,j,curr));
                }
            }
        }
//        printBoard(row, col, board);

        // 숫자 큰 CCTV 부터 훑어내려가는 게 좋아보인다.
        // 그것들이 좀더 많은 범위를 감시하기도 하니까.

        // 되돌아가는 걸 어떻게 해야할까 근데.
        // 복사한 맵에 대해서 해당 부분을 실행하던가 하자.


        // 모든 경우의 수를 조합으로 만들어서 저장하고
        // 그 조합을 모두 테스트하는 방법?

        // 나중에 더 풀어보자.

        for (Point point : pList) {
            if( point.cctvNo == 1){
                int max = -1;
                for(int i =0; i<4; i++){
                    int cctv01 = cctv01(point.x,point.y, i);
                    if( max < cctv01 ){
                        max = cctv01;
                    }
                }
            }
        }



        T.solution();
    }

    private static long zeroCount() {
        long count = 0L;
        for (int[] ints : board) {
            for (int i : ints) {
                if (i == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int cctv01(int i, int j , int dir){
        int count = 0 ;

        int dx = i + px[dir];
        int dy = j + py[dir];
        while( dx > 0 && dy > 0 && dx < row && dy  < row
                && board[dx][dy] != WALL
        ){
            if(board[dx][dy] == 0){
                board[dx][dy] = -1;
                count++;
            }
            dx = dx + px[dir];
            dy = dy + py[dir];
        }

        return count;
    }

    private static void printBoard(int row, int col, int[][] board) {
        for(int i = 0; i < row; i++){
            for(int j = 0; j< col; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void solution(){

    }
}
