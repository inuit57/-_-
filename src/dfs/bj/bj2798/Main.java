package dfs.bj.bj2798;

import java.util.Scanner;

public class Main {

    static int[] arr ;
    static boolean[] check ;

    static boolean[] visit ;

    static int answer = -1 ;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int n = in.nextInt();
        int m = in.nextInt();

        arr = new int[n];
        check = new boolean[n];

        for(int i =0 ; i< n ; i++){
            arr[i] = in.nextInt();
        }

        int max = -1;
        for(int i =0 ; i< n-2 ; i++){
            for(int j= i+1; j< n-1 ; j++){
                for(int k = j+1; k < n ; k++){
                    int sum = arr[i] + arr[j] + arr[k] ;
                    if(  m >= sum && sum > max ){
                        max = sum ;
                    }
                }
            }
        }

        System.out.println(max);
        //T.solution(0, m,0,n , 0);

//        System.out.println(answer);
    }

    private int calculate(int n){
        int sum = 0 ;
        for(int i =0 ; i< n; i++){
            if(check[i]) {
                sum += arr[i];
            }
        }
        return sum;
    }

    private void solution(int curr , int m, int cnt , int n, int sum ) {
        if( curr >= n) return; // 범위를 넘어가면 아웃
        if( sum > m ) return; // burst

        if( cnt == 3 && sum > answer ) {
            answer = sum ;   // 최댓값 계산.
        }

        if( sum + arr[curr] > m){
            solution(curr + 1, m, cnt, n, sum); // 상대할 가치도 없다.
        }else {
            check[curr] = true;  // 현재 위치의 카드를 넣는다.
            solution(curr + 1, m, cnt + 1, n, sum+arr[curr]);
            check[curr] = false; // 현재 위치의 카드를 넣지 않는다.
            solution(curr + 1, m, cnt, n , sum);
        }
    }

}
