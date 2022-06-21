package bfs.bj.bj16956;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Point{
        int x,y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int r = in.nextInt();
        int c = in.nextInt();

        ArrayList<Point> wolfs = new ArrayList<>();
        int[] px = {1,-1,0,0};
        int[] py = {0,0,1,-1};

        char[][] map = new char[r][c];

        for(int i = 0 ; i< r ; i++){
            char[] arr = in.next().toCharArray();
            for(int j =0 ; j< c ; j++){
                char curr = arr[j];
                if( curr == 'W') wolfs.add(new Point(i,j));
                map[i][j] = curr ;
            }
        }

        int answer = 1 ;

        if( !wolfs.isEmpty()) {
            for(Point w : wolfs){
                if( answer == 0) break;
                for(int i =0 ; i< 4; i++){
                    int dx = w.x + px[i];
                    int dy = w.y + py[i];

                    if( dx >=0 && dx < r && dy >=0 && dy < c){
                        // 인접한 곳에 양이 있을 경우
                        if( map[dx][dy] == 'S'){
                            answer = 0;
                            break;
                        }else if( map[dx][dy] == '.'){
                            map[dx][dy] = 'D';
                        }
                    }
                }
            }
        }
        System.out.println(answer);

        // D 없이 그냥 찍어줘도 문제가 될까?
        if( answer == 1) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
