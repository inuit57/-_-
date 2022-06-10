package dfs.marage;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n ;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        int[] arr = new int[73] ;
        for(int i=0 ; i< n;i++){
            int s = in.nextInt();
            int e = in.nextInt();
            for(int j= s; j<e ; j++){
                arr[j]++;
            }
        }

        System.out.println(Arrays.stream(arr).max().getAsInt());
    }

}
