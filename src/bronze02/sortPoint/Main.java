package bronze02.sortPoint;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class Point{
        int x,y ;
        protected Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ArrayList<Point> arr = new ArrayList<>();
        for(int i =0 ; i< n; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            arr.add(new Point(x,y));
        }

        arr.sort((o1,o2)->(o1.y == o2.y ? o1.x - o2.x : o1.y - o2.y));

        for (Point point : arr) {

            System.out.println(point.x + " " + point.y);
        }
    }

}
