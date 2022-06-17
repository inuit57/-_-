package dfs.bj.bj1987;

import java.util.*;

public class Main {

    static int[] px = {1,-1,0,0};
    static int[] py = {0,0,1,-1};
    static int n,m ;
    static char[][] arr;

    static HashSet<Character> chkSet = new HashSet<>();
    static int max ;
    static int count;


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        arr = new char[n][m] ;

        for(int i= 0 ; i< n ;i++){
            String str = in.next();
            arr[i] = str.toCharArray();
        }

//        printArr(n, m, arr);
        dfs(0,0);
        System.out.println(max);
    }

    private static boolean isPossible(int x,int y){
        return (x>=0 && y>=0 && n > x && m > y );
    }

    private static void dfs(int x, int y){
        if( isPossible(x,y) && !chkSet.contains(arr[x][y])){
            char curr = arr[x][y];
            count ++ ;
            chkSet.add(curr);
            max = Math.max(count,max);
            for(int i=0 ; i< 4; i++){
                int dx = x + px[i];
                int dy = y + py[i];
                dfs(dx,dy);
            }
            chkSet.remove(curr);
            count --;
        }
    }

    private static void printArr(int n, int m, char[][] arr) {
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }


}
