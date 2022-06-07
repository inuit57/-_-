package com.test;

import java.util.*;

public class Main {

    static class Point{
        int x, y ;
        Point(int x, int y ){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        ArrayList<Point> list = new ArrayList<>();
        for(int i =0 ; i < n ; i++){
            list.add(new Point(in.nextInt(), in.nextInt()));
        }

        list.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x != o2.x ?
                        o1.x - o2.x :
                        o1.y - o2.y;
            }
        });

        for(int i =0 ; i< n; i++){
            Point pt = list.get(i);
            System.out.println(pt.x + " " + pt.y);
        }
        return ;
    }

}