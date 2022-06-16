package dfs.bj2583;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] map ;
    static int[] px = {1,-1,0,0};
    static int[] py = {0,0,1,-1};

    static int cnt = 0 ;
    static ArrayList<Integer> cntArr = new ArrayList<>() ;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        map = new int[m][n] ;

        int k = in.nextInt();
        // 좌표 입력받기
        for(int i =0 ; i< k ; i++){
            int fx = in.nextInt();
            int fy = in.nextInt();
            int lx = in.nextInt();
            int ly = in.nextInt();
            for(int x = fx ; x< lx ; x++){
                for(int y= fy ; y < ly ; y++ ){
                    map[x][y] = 1;
                }
            }
            // 이렇게 받더라도 결국 대칭으로 받아지는 거라서 큰 차이는 없다.
        }

        //printArray();
        // dfs 순회 시작
        for(int i =0 ; i< n ; i++){
            for(int j =0 ; j< m ; j++){
                cnt = 0;
                if(map[j][i] == 0){
                    dfs(j,i);
                }
                if(cnt > 0) cntArr.add(cnt);
            }
        }// dfs 순회 끝

        Collections.sort(cntArr);
        System.out.println(cntArr.size());
        for(int c : cntArr){
            System.out.print(c+" ");
        }

    }

    private static void dfs(int y, int x ) {
        if( map[y][x] == 0){ // 먼저 체크하고 cnt 증가
            cnt ++ ;
            map[y][x] = 1;
        }
        for(int i =0 ; i< 4; i++){
            int dy = y + py[i];
            int dx = x + px[i];
            if(dy >= 0 && dx >=0 && m > dy && n > dx && map[dy][dx] == 0){
                dfs(dy,dx);
            }
        }
    }

    private static void printArray() {
        for(int i = 0; i< n; i++){
            for(int j =0 ; j< m ; j++){
                System.out.print(map[j][i]);
            }
            System.out.println();
        }
    }
}
