package bfs.bj.bj2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[][] visit ;
    static int[][] arr ;
    static int[] px = {1,-1,0,0};
    static int[] py = {0,0,1,-1};

    static int n, m ;

    public static class Point{
        int x, y ;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        arr = new int[n][m] ;
        visit = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            String str = in.next();
            for(int j =0 ; j< m ; j++){
                arr[i][j] = str.charAt(j) - '0' ;
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));

        int answer = 0 ;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0 ; i< size; i++){
                Point p = queue.poll();
                if( p.x == n-1 && p.y == m-1) {
                    queue.clear();
                    break;
                }
                visit[p.x][p.y] = true;
                for(int j=0; j< 4; j++){
                    int dx = p.x + px[j];
                    int dy = p.y + py[j];

                    if( dx >= 0 && dy >= 0 && n > dx && m > dy && !visit[dx][dy] && arr[dx][dy] == 1) {
                        visit[dx][dy] = true;
                        queue.add(new Point(dx, dy));
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
//        printArr(n, m, arr);

    }

    private static void printArr(int n, int m, int[][] arr) {
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
