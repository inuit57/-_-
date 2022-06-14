package DP.LIP2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static class Lego{
        public Lego(int size, int height, int weight) {
            this.size = size;
            this.height = height;
            this.weight = weight;
        }

        /**
         * 현재 벽돌 위에 새로운 벽돌을 올리는 것이 가능한지 판단하는 함수
         * @param lego
         * @return
         */
        public boolean isPossible(Lego lego){
            return ( this.size > lego.size ) && (this.weight > lego.weight);
        }


        int size;
        int height;
        int weight;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int n = in.nextInt();
        ArrayList<Lego> legos = new ArrayList<>();
        for(int i = 0 ; i<n; i++){
            int size = in.nextInt();
            int height = in.nextInt();
            int weight = in.nextInt();
            legos.add(new Lego(size,height,weight)) ;
        }

        Collections.sort(legos, (o1,o2)->{
            if(o1.size == o2.size) return o2.height - o1.height;
            else return o2.size - o1.size;
        });

        System.out.println(T.solution( legos ));
    }

    public int solution(ArrayList<Lego> legos){
        int dy[] = new int[legos.size()];
        dy[0] = legos.get(0).height;

        for(int i =1 ; i< legos.size() ; i++){
            int max = legos.get(i).height;
            for( int j= i-1 ; j>=0 ; j--){
                if( legos.get(j).isPossible(legos.get(i)) ){
                    //dy[i] = legos.get(i).height + dy[j] ;
                    max = Math.max(max, legos.get(i).height + dy[j]);
                }
            }
            dy[i] = max;
        }
        
//        for(int i =0 ; i< dy.length ;i++){
//            System.out.println("dy["+i+"] = " + dy[i]);
//        }
        return Arrays.stream(dy).max().getAsInt();
    }
}
