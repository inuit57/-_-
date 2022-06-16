package dfs.bj2667;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int n ;
    static int[][] map ;

    static int cnt;

    int[] px = {1,-1,0,0};
    int[] py = {0,0,1,-1};

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        n = in.nextInt();
        map = new int[n][n] ;
        for(int i =0 ; i<n; i++){
            String str = in.next();
            for(int j= 0 ;j<n; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        //printArr();
        ArrayList<Integer> cntArr = new ArrayList<>();
        for(int i =0 ;i<n; i++){
            for(int j=0 ; j<n; j++){
                cnt =0 ;
                if( map[i][j] == 1) T.dfs(i,j);
                if(cnt > 0) cntArr.add(cnt);
            }
        }

        Collections.sort(cntArr);
        System.out.println(cntArr.size());
        for (int c : cntArr){
            System.out.println(c);
        }
    }

    private static void printArr() {
        for(int i =0 ; i< n; i++){
            for(int j =0 ;j < n; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private void dfs(int x, int y) {
        if( map[x][y] == 1){
            map[x][y] = 0;
            cnt ++ ;
        }
        for(int i =0 ; i< 4; i++){
            int dx = x + px[i] ;
            int dy = y + py[i] ;
            if( dx >=0 && dy >= 0 && n > dx && n > dy && map[dx][dy] == 1){
                dfs(dx,dy);
            }
        }
    }

}
