package test001;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static class People{
        int no;
        int h;
        int w;
        People(int no,int h, int w){
            this.no = no ;
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n= in.nextInt();
        ArrayList<People> arr = new ArrayList<>();
        for(int i =0 ; i< n ; i++){
            int h = in.nextInt();
            int w = in.nextInt();
            arr.add(new People(i,h,w));
        }

        arr.sort(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o2.h - o1.h;
            }
        });

        int max = -1;
        int answer = 0 ;
        for(int i =0;  i< n ; i++){
            People curr = arr.get(i);
            //System.out.println(curr.no + ":"+curr.h+":"+curr.w);
            if( curr.w > max){
                max = curr.w;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
