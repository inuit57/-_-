package sort.binary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();  // 나눌 갯수

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr,n,m));

    }

    int solution(int[] arr, int n, int k){
        int answer = Integer.MAX_VALUE ;
        int max = 0;
        for(int i =0 ; i< n; i++){
            max += arr[i] ;
        }
        int min = max / k ;
        // 결정 알고리즘에서는 최소, 최댓값 범위 설정이 중요하다.

        while( min < max){
            int mid = (min + max)/2 ;

            int chk = check(arr, k, mid);
            if( chk < 0){
                min = mid+1;
            }
            else if(chk > 0){
                answer = Math.min(mid,answer); // 현재 최댓값을 저장하자.
                max = mid;
            }
        }
        return answer;
    }

    private int check(int[] arr, int k, int mid) {
        int cnt = 1 ;
        int sum = 0 ;
        for(int x : arr){
            sum += x ;
            if(sum > mid){
                sum = x ;
                cnt++ ;
            }
            if( cnt > k ) return -1; // mid 증가 필요
        }
        return 1 ;  // mid 값 감소 필요
    }
}
