package dfs.bj.bj11724;

import java.util.*;

public class Main {

    static class Point implements Comparable<Point> {
        int sp, ep ;

        Point(int sp,int ep){
//            this.sp = sp;
//            this.ep = ep;

            this.sp = Math.min(sp,ep);
            this.ep = Math.max(sp,ep);
        }

        @Override
        public int compareTo(Point o) {
            return this.sp == o.sp ? this.ep - o.ep : this.sp - o.sp ;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] chk = new int[n+1] ;  //
        for(int i =0 ; i<= n ; i++){
            chk[i] = i;
        }

        List<Point> pList = new ArrayList<>();
        for(int i =0  ; i< m ; i++){
            int a = in.nextInt();
            int b = in.nextInt();

            pList.add(new Point(a,b));
        }

        Collections.sort(pList);
        for(Point p : pList){
            //System.out.println(p.sp +"," + p.ep);
            int gp = p.sp ;
            while( chk[gp] != gp ){
                gp = chk[chk[gp]];
            }
            chk[p.ep] = gp ;
        }

        for(int i =n; i > 0 ;i--){
            if( chk[i] != i){
                chk[i] = chk[chk[i]];
            }
        }

        long count = Arrays.stream(chk).distinct().count();
        System.out.println(count-1);
    }

}
