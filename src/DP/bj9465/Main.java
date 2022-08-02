package DP.bj9465;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        StringBuilder sb = new StringBuilder();
        int t = in.nextInt(); // 테스트 케이스 갯수
        for(int ti = 0 ; ti < t ; ti++){

            // 테스트 케이스 입력 받기
            int n = in.nextInt();
            int[][] arr = new int[2][n] ;
            for(int kk =0; kk < 2; kk ++){
                for(int ni = 0 ; ni < n ; ni++){
                    arr[kk][ni] = in.nextInt();
                }
            }
            // 테스트 케이스 입력 끝

            sb.append(T.solution(arr,n));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public int solution(int[][] arr, int n){
        int[][] chk = new int[2][n]; // DP 계산용 배열

        // 초깃값 세팅
        chk[0][0] = arr[0][0] ;
        chk[1][0] = arr[1][0] ;

        if( n < 2 ) {
            return Math.max(chk[0][0] ,chk[1][0] );
        }


        chk[0][1] = arr[0][1] + chk[1][0] ;
        chk[1][1] = arr[1][1] + chk[0][0] ;

        // 대각선 지그재그로 계산 더하게끔 하면 되지 않나?
        // 다른 고려사항이 있을까요? max 까지 할 것도 없지 싶은데.

        // 첫번째 케이스에서 변수가 있긴 했네요.
        // 2거리 정도까지 차이 나는 것까지 고려를 했어야 했나?

        // chk[0][n] = arr[0][n] (현위치값)
        // 비교대상1 : chk[1][n-1] , 이전 위치 대각선
        // 비교대상2 : chk[0][n-2], chk[1][n-2] , 바로 전전 항목들 중 하나
        // (비교대상2로 갈 경우에는 이전 위치 대각선을 아예 안 쓰겠다는 뜻)

        for(int i =2; i< n ; i++){
            chk[0][i] = arr[0][i] + threeMax(chk[1][i-1],chk[0][i-2],chk[1][i-2]);
            chk[1][i] = arr[1][i] + threeMax(chk[0][i-1],chk[0][i-2],chk[1][i-2]);
        }

        return Math.max(chk[0][n-1], chk[1][n-1]);

    }

    private int threeMax(int a,int b,int c){
        return Math.max(Math.max(a,b),c);
    }
}
