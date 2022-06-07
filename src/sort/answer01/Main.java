package sort.answer01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int count(int[] arr, int cap){
        int cnt =1 , sum =0 ;
        for(int x : arr){
            if(sum+x >cap){
                cnt ++ ;
                sum = x;
            }else  sum+=x;
        }
        return cnt;
    }

    public int solution(int n, int m, int[] arr){
        int answer = 0 ;
        int lt = Arrays.stream(arr).max().getAsInt();
        // stream 을 통해서 max 값을 뽑아내준다.
        // 굳이 정렬하지 않고도 최댓값, 최솟값을 뽑아낼 수 있다.

        int rt = Arrays.stream(arr).sum();
        // stream 을 통해서 한 번에 합을 구해줄 수 있다.

        while (lt <= rt){
            int mid = (lt + rt)/2 ;
            // DVD 한 장의 용량
            if( count(arr,mid) <= m ){
                // 나올 수 있는 장수를 확인한다.
                // 만약 m 장 이하라면 된다고 판정
                answer = mid; // 더 좁혀나가니까 굳이 비교함수를 쓸 필요는 없었네.
                rt = mid - 1;
            }else{
                lt = mid+1;
            }
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
