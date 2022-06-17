package bfs.bj.bj1987;

import java.util.*;

public class Main {

    static int[] px = {1,-1,0,0};
    static int[] py = {0,0,1,-1};
    static int n,m ;
    static char[][] arr;

    static class Point{

        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        public Point(int x,int y, char ch, Point p){
            this(x,y);
            this.set = new HashSet<>(p.set) ;
            this.set.add(ch);
        }

        public Point(int x, int y, char ch) {
            this.x = x;
            this.y = y;
            set.add(ch);
        }

        int x,y ;
        HashSet<Character> set = new HashSet<>();

        boolean isContains(char ch){
            return set.contains(ch);
        }
    }

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
        System.out.println(solution(n,m,arr));

    }

    private static boolean isPossible(int x,int y){
        return (x>=0 && y>=0 && n > x && m > y );
    }

    private static int solution(int n,int m ,char[][] arr){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,arr[0][0]));

        int L = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i =0 ; i< size; i++){
                Point p = queue.poll();
                // 4방향 탐색 후 큐에 집어넣어주기
                for(int j = 0 ; j<4; j++){
                    int dx = p.x + px[j];
                    int dy = p.y + py[j];
                    if( isPossible(dx,dy) ){
                        char ch = arr[dx][dy] ;
                        if(!p.isContains(ch)){
                            queue.offer(new Point(dx,dy,ch,p));
                        }else{
//                            for(char xxxx : p.set){
//                                System.out.print(xxxx);
//                            }
//                            System.out.println();
                        }
                    }
                }
            }
            L++ ;
        }
        return L ;
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
