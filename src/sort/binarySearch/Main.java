package sort.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int find = in.nextInt();

        int[] arr = new int[n] ;
        for(int i =0 ; i < n; i++) arr[i] = in.nextInt();

        Arrays.sort(arr); // 정렬
        System.out.println(T.solution(arr,0,n,find)+1);
    }

    private int solution(int[] arr,int start, int end, int find) {
        if(start > end) return -1 ;  //못찾음
        int mid = (start+end)/2;

        if( arr[mid] == find ) {
            return mid; // 답 찾음
        }else if( arr[mid] > find){
            return solution(arr, start, mid-1, find);
        }else{
            return solution(arr, mid+1, end, find);
        }
    }

}
