package dfs.maze01;

import java.util.LinkedList;
import java.util.Queue;
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
//        maze[0][0] = 1 ; // 이걸 안 해주면 2배수가 되어버린다.

//        T.DFS(0,0);
//        System.out.println(answer);
        System.out.println(T.BFS(0,0));
    }

    static class Point{
        int x, y ;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private int BFS(int x, int y){
        // 시작점 입력 받기
        int L = 0 ;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i =0 ; i< len ;i++){
                Point curr = queue.poll();
                maze[curr.x][curr.y] = 1;  // 되돌아가지 못하도록 막기

                if( curr.x == 6 && curr.y == 6) {
                    return L;
                }

                for(int j= 0 ; j< 4; j++){
                    int dx = curr.x + px[j];
                    int dy = curr.y + py[j];
                    if( dx < 7 && dy < 7 && dx >=0 && dy >= 0 && maze[dx][dy]!=1){
                        queue.add(new Point(dx,dy));
                    }
                }
            }
            L++;
        }
        return L ;
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
