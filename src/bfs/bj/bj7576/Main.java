package bfs.bj.bj7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static class Point{
        int x,y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] px = {1,-1,0,0};
    static int[] py = {0,0,1,-1};

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        Queue<Point> queue = new LinkedList<>();

        int[][] arr = new int[b][a];
        int zeroCnt = 0 ;
        for(int i =0 ; i< b; i++){
            for(int j =0 ; j< a; j++){
                int tomato = in.nextInt();
                arr[i][j] = tomato ;
                if( tomato == 1) {
                    queue.add(new Point(i, j));
                }else if( tomato == 0 ){
                    zeroCnt ++;
                }
            }
        }

//        printArr(a, b, arr);

        if( zeroCnt == 0) {
            System.out.println(0);
            return; // 처음부터 모두 익어있다.
        }

        int L = -1 ;
        while (!queue.isEmpty()){
            int size = queue.size();
            L++;
            for(int i =0; i< size; i++){
                Point p = queue.poll();

                for(int j=0; j< 4; j++){
                    int dx = p.x + px[j];
                    int dy = p.y + py[j];

                    if( dx >= 0 && dy >= 0 && dx < b && dy < a &&
                        arr[dx][dy] == 0
                    ){
                        arr[dx][dy] = 1;
                        queue.add(new Point(dx,dy));
                    }
                }
            } // for (queue size)
        } // while

        boolean isOk = true;
        for(int i =0 ; i< b; i++){
            for(int j =0 ; j<a ; j++){
                if( arr[i][j] == 0 ){
                    isOk = false;
                    i= b;
                    break;
                }
            }
        }

        if(isOk){
            System.out.println(L);
        }else {
            System.out.println(-1);
        }


    }

    private static void printArr(int a, int b, int[][] arr) {
        for(int i = 0; i< b; i++){
            for(int j = 0; j< a; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}
