package sort.answer02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int count(int[] arr, int dist){
        int cnt = 1;  // 배치한 말의 마릿수
        int ep = arr[0] ; // end point
        for(int i =1; i< arr.length ; i++){
            if( arr[i] - ep >= dist){
                cnt ++;
                ep = arr[i] ;
            }
        }
        return cnt;
    }

    public int solution(int n, int c, int[] arr){
        int answer = 0 ;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n-1] ;
        while(lt <= rt){
            int mid = (lt+rt)/2 ;
            if( count(arr,mid) >= c){
                answer = mid ;
                lt = mid +1;
            }else rt = mid -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();  // 나눌 갯수

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(T.solution(n,m,arr));

    }
}
