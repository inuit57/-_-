package DP.정수삼각형;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int n = in.nextInt(); // 높이 입력받기
        int[][] tri = new int[n][n] ; // 적당히 55짜리로 만들자.
        // 동적 배열 초기화로 삼각형 형태를 만들 수도 있지만 귀찮다.

        in.nextLine();
        for(int i =0 ; i< n; i++){
            String str = in.nextLine();
            String[] split = str.split(" ");
            for(int j=0; j< split.length ; j++){
                tri[i][j] = Integer.parseInt(split[j]);
            }
        }// 입력 끝.

        System.out.println(T.solution( tri , n ));
    }

    public int solution(int[][] arr, int n ){
        int[][] answer = arr.clone();  // 복제해버리자.

        if( n == 1) return arr[0][0];

        answer[1][0] += answer[0][0];
        answer[1][1] += answer[0][0];

        // 맨 왼쪽은 선택의 여지가 없다.
        // 그리고 나중에 계산을 일관화하기 어려우니까 먼저 계산치자.
        for(int i =2; i< n ; i++){
            answer[i][0] += answer[i-1][0];
        }

        for(int i=2; i< n ; i++){
            for(int j=1; j<=i ; j++){
                answer[i][j] += Math.max(answer[i-1][j], answer[i-1][j-1]);
            }
        }

//        printArr(n, answer);

        return Arrays.stream(answer[n - 1]).max().orElse(0);
    }

    private void printArr(int n, int[][] answer) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< n; i ++){
            for(int j =0; j<= i; j++){
                sb.append(answer[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
