package maxIncreNumbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr ;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int n = in.nextInt();
        arr = new int[n];

        for(int i =0 ; i<n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr));
    }



    private int solution(int[] arr) {
        int[] dy = new int[arr.length];
        dy[0] = 1;
        for(int i = 1; i< arr.length; i++){
            int max = 0;
            for(int j =i; j>=0 ; j--){
                if( arr[i] > arr[j] ) {
                    max = Math.max(max, dy[j]);
                }
            }
            dy[i] = 1+ max;
        }
        return Arrays.stream(dy).max().getAsInt();
    }
}
