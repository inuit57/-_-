package DP.내려가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main T = new Main();

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3] ;

        for(int i =0 ; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0 ; j< 3; j++){
                String s = st.nextToken();
                arr[i][j] = Integer.parseInt(s);
            }
        }

        ArrayList<Integer> answer = T.solution(arr, n);
        System.out.println(answer.get(0) + " " + answer.get(1));
    }

    public ArrayList<Integer> solution(int[][] arr, int n){
        int[][] minDp = new int[2][3];
        int[][] maxDp = new int[2][3];

        for(int i=0; i< 3; i++){
            maxDp[0][i] = minDp[0][i] = arr[0][i];
        }

        int curr = 0; // n = 1 일 때 대비
        for(int i=1; i< n; i++){
            curr = i%2;
            minDp[curr][0] = Math.min(minDp[1-curr][0],minDp[1-curr][1]) + arr[i][0];
            maxDp[curr][0] = Math.max(maxDp[1-curr][0],maxDp[1-curr][1]) + arr[i][0];

            minDp[curr][1] = Arrays.stream(minDp[1-curr]).min().orElse(0) + arr[i][1];
            maxDp[curr][1] = Arrays.stream(maxDp[1-curr]).max().orElse(0) + arr[i][1];

            minDp[curr][2] = Math.min(minDp[1-curr][2],minDp[1-curr][1]) + arr[i][2];
            maxDp[curr][2] = Math.max(maxDp[1-curr][2],maxDp[1-curr][1]) + arr[i][2];
        }

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add( Arrays.stream(maxDp[curr]).max().orElse(0) );
        answer.add( Arrays.stream(minDp[curr]).min().orElse(0) );

        return answer;
    }
}
