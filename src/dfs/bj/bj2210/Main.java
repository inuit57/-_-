package dfs.bj.bj2210;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static int cnt = 0;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Set<String> set = new HashSet<>();
    static boolean[][] visit = new boolean[5][5];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] board = new int[5][5] ;

        for(int i=0; i< 5; i++){
            for(int j=0; j< 5; j++){
                board[i][j] = in.nextInt();
            }
        }

        for(int i=0; i< 5; i++){
            for(int j=0; j< 5; j++){
                dfs(0,board,i,j,new StringBuilder().append(board[i][j]) );
            }
        }

//        set.add("test");
//        boolean test = set.add("test");
//        System.out.println(test);
        System.out.println(cnt);
    }

    public static void dfs(int depth, int[][] board,int x,int y, StringBuilder sb){
        if( depth >= 5){
            if(set.add(sb.toString())) {
                //System.out.println(sb.toString());
                cnt++;
            }
            return;
        }

        for(int i=0; i< 4; i++){
            int px = x+ dx[i];
            int py = y+ dy[i];
            if( px >= 0 && px < 5 && py >=0 && py <5){ // && !visit[px][py] ){
                sb.append(board[px][py]);
                dfs(depth+1, board, px,py, sb);
                sb.deleteCharAt(depth+1);
            }
        }
    }
}
