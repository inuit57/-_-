package bfs.bj.bj3055;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Point{
        int x, y;
        public Point(int x,int y){
            this.x = x ;
            this.y = y ;
        }

        public boolean equals(Point obj) {
            return x == obj.x && y == obj.y;
        }
    }

    static int[] px = {1,-1,0,0};
    static int[] py = {0,0,1,-1};

    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        // . : 0
        // * : 1
        // D : 2
        // S : 3
        // X : 9
        int[][] map = new int[n][m] ;
        Point obj = new Point(0,0);

        for(int i = 0 ; i< n ;i++){
            char[] arr = in.next().toCharArray();
            for(int j =0 ; j < m ; j++){
                if( arr[j] == 'D'){
                    map[i][j] = 2;
                    obj = new Point(i,j);
                }
                if( arr[j] == '.') map[i][j] = 0;
                if( arr[j] == 'S'){
                    queue.add(new Point(i,j)) ;
                    map[i][j] = 3;
                }
                if( arr[j] == '*') map[i][j] = 1;
                if( arr[j] == 'X') map[i][j] = 9; // 돌
            }
        }


        int answer = bfs(n, m, map, obj);
        if( answer < 0 ) System.out.println("KAKTUS");
        else System.out.println(answer);
    }

    private static int bfs(int n, int m, int[][] map, Point obj) {
        int L = 0 ;

        boolean[][] check = new boolean[n][m];
        while(!queue.isEmpty()){
            // 물 먼저 확장시키기
            expandWater(n, m, map);
//            printMap(n, m, map);

            int size = queue.size();
            for(int i =0 ; i< size ; i++){
                Point p = queue.poll();
                if( p.equals(obj)) return L;

                check[p.x][p.y] = true;
                map[p.x][p.y] = 0;

                for(int k =0 ; k< 4; k++){
                    int dx = p.x + px[k];
                    int dy = p.y + py[k];
                    if(dx >=0 && dy >=0 &&
                        dx < n && dy < m &&
                            (map[dx][dy] == 0 || map[dx][dy] == 2) &&
                            !check[dx][dy]
                    ){
                        queue.add(new Point(dx,dy));
                    }
                }
            }
            L++ ;

        } // while end
        return -1;
    }

    private static void printMap(int n, int m, int[][] map) {
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void expandWater(int n, int m, int[][] map) {
        boolean[][] check = new boolean[n][m];
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if( map[i][j] == 1){
                    for(int k = 0 ; k < 4; k++){
                        int dx = i + px[k] ;
                        int dy = j + py[k] ;

                        if( dx >=0 && dy >=0 &&
                                dx < n && dy < m &&
                                (map[dx][dy] == 0 ) && !check[i][j]
                        ){
                            check[dx][dy] = true;
                            map[dx][dy] = 1;
                        }
                    }
                }
            }
        }
    }

}
