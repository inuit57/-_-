package dfs.island;

import java.util.Scanner;

public class Main {

    static int[][] map ;
    static int answer =0 ;
    static int n;
    int[] px = {1,-1,0,0,1,1,-1,-1};
    int[] py = {0,0,1,-1,1,-1,1,-1};

    private void dfs(int x,int y){
        for(int i =0; i< 8 ; i++){
            int dx = x+px[i];
            int dy = y+py[i];

            if( dx < n && dy < n && dx >=0 && dy >= 0 && map[dx][dy]==1){
                map[dx][dy] = 0 ;
                dfs(dx,dy);
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        map = new int[n][n];
        // 값 저장
        for(int i =0 ; i< n; i++){
            for(int j=0 ; j< n; j++){
                map[i][j] = in.nextInt();
            }
        }

        for(int i =0 ; i<n; i++){
            for(int j=0; j<n; j++){
                if( map[i][j] == 1){
                    answer++;
                    map[i][j] = 0;  // 방문했으니 0으로 처리
                    T.dfs(i,j);
                }
            }
        }
        System.out.println(answer);
    }
}
