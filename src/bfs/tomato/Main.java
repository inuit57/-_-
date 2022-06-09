package bfs.tomato;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] box ;
    static int n ,m;
    static Queue<Point> queue = new LinkedList<>();

    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    int[] px = {1,-1,0,0};
    int[] py = {0,0,1,-1};

    private int BFS(){
        int L = 0 ;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0 ; i< len; i++){
                Point curr = queue.poll();
                for(int j=0 ; j< 4; j++){
                    int dx = curr.x + px[j];
                    int dy = curr.y + py[j];
                    if(
                            (dx < m && dy < n)
                            && (dx >= 0 && dy >=0)
                            && (box[dx][dy] == 1)
                    ){
                        box[dx][dy]=2;
                        queue.add(new Point(dx,dy));
                    }
                }
            }
            L++;
        }

        // 다 돌리고 안 익은 거 검사
        for(int i =0 ; i< m; i++) {
            for (int j = 0; j < n; j++) {
                if(box[i][j] == 1){
                    return -1 ;
                }
            }
        }
        // 미리 넣어놓았으니까 -1 을 해줘야한다.
        return L-1 ;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        box = new int[m][n];

        boolean flag = true;
        for(int i =0 ; i< m; i++){
            for(int j =0 ; j<n ; j++){
                int tom = in.nextInt()+1;
                box[i][j] = tom;
                if(tom == 2){
                    queue.add(new Point(i,j));
                }else if(tom == 1){
                    flag = false; 
                    // 덜 익은 토마토가 있는지 파악
                }
            }
        }
        if( flag ){
            // 모든 토마토가 익어있다.
            System.out.println(0);
            return;
        }
        System.out.println(T.BFS()-1);
    }
}
