package dfs.maze01;

import java.util.Scanner;

public class Main {

    // 이동 좌표
    int[] px = { 1,-1, 0, 0} ;
    int[] py = { 0, 0, 1, -1} ;

    static int answer =0 ; // 탈출 갯수 체크용

    static int[][] maze = new int[7][7];
    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        // 값 설정
        for(int i=0 ; i<7; i++){
            for(int j =0 ; j< 7 ; j++){
                maze[i][j] = in.nextInt();
            }
        }
        T.DFS(0,0);
        System.out.println(answer/2);
    }

    private void DFS(int x, int y){
        if( x == 6 && y == 6){
            answer++ ;
            return;
            // 목표지점 도착
        }
        for(int i =0 ; i< 4; i++){
            int dx = x + px[i];
            int dy = y + py[i];
            if( dx < 7 && dy <7 && dx >=0 && dy >=0 && maze[dx][dy] != 1){
                maze[dx][dy] =1 ;
                DFS(dx,dy);
                maze[dx][dy] =0 ; // 다시 열어주기
            }
        }
    }
}
