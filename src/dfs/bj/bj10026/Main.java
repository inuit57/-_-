package dfs.bj.bj10026;

import java.util.Scanner;

public class Main {

    static int[][] arr;
    static int[][] arrRG;
    static boolean[][] visit ;
    static boolean[][] visitRG ;

    static int[] px = {1,-1,0,0};
    static int[] py = {0,0,1,-1};
    static int n;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        n = in.nextInt();
        arr = new int[n][n] ;
        arrRG = new int[n][n];
        visit = new boolean[n][n] ;
        visitRG = new boolean[n][n] ;

        for(int i=0 ; i< n ;i++){
            String str = in.next();
            for(int j=0 ; j< n; j++){
                arr[i][j] = str.charAt(j);

                arrRG[i][j] = str.charAt(j);
                if( arrRG[i][j] == 'G'){
                    arrRG[i][j] = 'R';
                }
            }
        }

//        printArr(n, arr);

        int cnt = 0;
        int cntRG = 0;
        for(int i =0 ; i< n ; i++){
            for(int j= 0 ; j< n ; j++){
                if( !visit[i][j] ){
                    cnt ++;
                    T.dfs(i,j);
                }
                if( !visitRG[i][j]){
                    cntRG ++;
                    T.dfsRG(i,j);
                }
            }
        }
        System.out.println(cnt + " "+ cntRG);
    }

    public void dfsRG(int x, int y) {
        visitRG[x][y] = true;
        for(int i = 0 ;i < 4; i++){
            int dx = x + px[i] ;
            int dy = y + py[i] ;

            if( isPossible(dx,dy) && arrRG[dx][dy] == arrRG[x][y] && !visitRG[dx][dy]){
                dfsRG(dx,dy);
            }
        }
    }

    public void dfs(int x, int y) {
        visit[x][y] = true;
        for(int i = 0 ;i < 4; i++){
            int dx = x + px[i] ;
            int dy = y + py[i] ;

            if( isPossible(dx,dy) && arr[dx][dy] == arr[x][y] && !visit[dx][dy]){
                dfs(dx,dy);
            }
        }
    }

    private static void printArr(int n, int[][] arr) {
        for(int i = 0; i< n; i++){
            for(int j = 0; j< n; j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }

    private static boolean isPossible(int x,int y ){
        return (x >=0 && y >= 0 && n > x && n > y ) ;
    }
}
