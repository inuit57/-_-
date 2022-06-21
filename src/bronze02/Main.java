package bronze02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int[][] arr = {
                {10},
                {1},
                {6,2,4,8},
                {1,3,9,7},
                {6,4},
                {5},
                {6},
                {1,7,9,3},
                {6,8,4,2},
                {1,9}
        };
        int n = in.nextInt();
        for(int i= 0 ; i< n; i++){
            int k = in.nextInt() % 10 ;
            int m = in.nextInt(); // 반복 횟수

            System.out.println(arr[k][m%(arr[k].length)]);
        }
    }

}
