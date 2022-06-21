package dfs.bj.bj2466;

import java.util.Scanner;

public class Main {

    static int[] px = {1,-1,0,0};
    static int[] py = {0,0,1,-1};
    static boolean[][] check;
    static int n ;
    static int[][] map;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        n = in.nextInt();
        map = new int[n][n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i=0 ; i< n ;i++){
            for (int j=0 ; j< n ;j++){
                int input = in.nextInt();
                map[i][j] = input;
                min = Math.min(min,input);
                max = Math.max(max,input);
            }
        }

        // wh : water height
        // wh 이하는 잠긴다.
        int answer = 1 ; // 모두 잠기지 않는 경우 (답의 최솟값)
        for(int wh = min ; wh < max ; wh++){
            int cnt = 0 ;
            check = new boolean[n][n]; // 방문 체크용 배열 초기화

            for(int i =0 ; i< n ; i++){
                for(int j=0 ; j< n; j++){
                    if( map[i][j] > wh && !check[i][j] ){
                        T.dfs(i,j,wh);
                        cnt ++ ;  // 한 번 돌 때마다 섬 갯수를 하나씩 증가시킨다.
                    }
                }
            }
            answer = Math.max(cnt, answer);
        }

        System.out.println(answer);

    }

    private void dfs(int x, int y, int wh) {
        check[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int dx = x + px[i];
            int dy = y + py[i];

            if (dx >= 0 && dy >= 0 && dx < n && dy < n && map[dx][dy] > wh && !check[dx][dy]) {
                dfs(dx, dy, wh);
            }
        }
    }

}
