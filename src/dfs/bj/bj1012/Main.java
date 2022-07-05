package dfs.bj.bj1012;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static boolean[][] visit ;
    static int[][] map ;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt(); // 테스트 케이스 갯수

        List<Integer> answerList = new ArrayList<>();
        for(int i =0; i< t ; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt(); // 배추 갯수
            map = new int[n][m] ;
            visit = new boolean[n][m];

            for(int ki = 0; ki < k ; ki++){
                int x = in.nextInt();
                int y = in.nextInt();
                map[x][y] = 1;
            }

            int cnt = 0 ;
            for(int ni = 0 ; ni <n ; ni++){
                for(int mi =0 ; mi < m ; mi++){
                    if( map[ni][mi] == 1 && !visit[ni][mi] ){
                        visit[ni][mi] = true;
                        dfs(ni,mi , n, m ) ;
                        cnt ++ ;
                    }
                }
            }
            answerList.add(cnt);
        }

        for(int answer : answerList){
            System.out.println(answer);
        }
    }



    static void dfs(int x, int y , int n, int m ){
        int[] px = {1,-1,0,0};
        int[] py = {0,0,1,-1};

        for(int i =0 ; i< 4; i++){
            int dx = x+px[i];
            int dy = y+py[i];

            if( dx >=0 && dy >=0 && n > dx && m > dy && map[dx][dy] == 1 && !visit[dx][dy]){
                visit[dx][dy] = true;
                dfs(dx,dy,n,m);
            }
        }
    }

}
