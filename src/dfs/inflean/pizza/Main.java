package dfs.inflean.pizza;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n ,m ,pizza_num ;

    static ArrayList<Point> home = new ArrayList<>();
    static ArrayList<Point> pizza = new ArrayList<>();

    static boolean[] check;

    static ArrayList<Point> chk = new ArrayList<>();

    static int answer = Integer.MAX_VALUE;

    static class Point{
        int x,y ;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int getDistance(Point p){
            return Math.abs(p.x - this.x) + Math.abs(p.y-this.y);
        }

        public int getMinDistance(ArrayList<Point> list){
            int min = Integer.MAX_VALUE;
            for(Point p : list){
                min = Math.min(this.getDistance(p),min);
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        // map 은 굳이 필요없다. 새로 박을 게 아니니까.
        for(int i= 0 ; i< n; i++){
            for(int j =0 ; j< n; j++){
                int cur = in.nextInt();
                if(cur == 1){
                    home.add(new Point(i,j));
                }else if(cur == 2){
                    pizza.add(new Point(i,j));
                }
            }
        }

        // 피자집 갯수만큼의 체크 배열 생성
        check = new boolean[pizza.size()];
        pizza_num = pizza.size();


//         1) M개의 피자집을 고른다.
//         2) 골라진 파자집들을 가지고 최소 거리를 계산한다.
//         3) 모든 조합의 경우를 확인할 때까지 반복한다.
        T.DFS2(0 , 0);

        System.out.println(answer);

    }

    private void DFS(int L, int cnt) {
        // 갯수가 m가 되었다면
        if( cnt == m) {
            for(int i=0 ; i< pizza_num ;i++){
                if(check[i]){
                    System.out.print(i+1 + " ");
                }
            }
            System.out.println();
//            ArrayList<Point> selected = new ArrayList<>();
//            for(int i =0 ; i< pizza.size(); i++){
//                if(check[i]){
//                    selected.add(pizza.get(i));
//                }
//            }
//            System.out.println("test: " + selected.size());
//            for (Point p : selected) {
//                System.out.println("p.x +\":\"+p.y = " + p.x + ":" + p.y);
//            }
        }else if(L < pizza_num && !check[L]){
            check[L] = true;
            DFS(L+1, cnt+1);
            check[L] = false;
            DFS(L+1, cnt);
        }
    }

    private void DFS2(int L, int cnt) {
        // 갯수가 m가 되었다면
        if( cnt == m) {
            int sum = 0 ;
            for(Point p : home){
                sum += p.getMinDistance(chk);
            }
            answer = Math.min(sum,answer);
        }else if(L < pizza_num){
            Point p = pizza.get(L);
            if(!chk.contains(p)) {
                chk.add(p);
                DFS2(L + 1, cnt + 1);
                chk.remove(p);
                DFS2(L + 1, cnt);
            }
        }
    }
}
