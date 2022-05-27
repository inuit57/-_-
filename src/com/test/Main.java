package com.test;

import java.util.Scanner;

public class Main {

    static int[][] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int stu, ex;
        stu = in.nextInt(); // 4
        ex = in.nextInt(); // 3

        arr = new int[ex][stu];
        for (int i = 0; i < stu; i++) {
            for (int j = 0; j < ex; j++) {
                arr[i][j] = in.nextInt();
            }
        }


        System.out.println("n = " + solution(stu, ex));
    }


    private static int solution(int stu, int ex) {
        int answer = 0;
        for (int i = 1; i <= stu; i++) {
            for (int j = 1; j <= stu; j++) {
                // 학생 조합 설정
                int cnt = 0;
                for (int k = 0; k < ex; k++) {
                    int pi = 0, pj = 0;
                    for (int s = 0; s < stu; s++) {
                        if (arr[k][s] == i) pi = s;
                        if (arr[k][s] == j) pj = s;
                    }
                    if (pi < pj) cnt++;
                }
                if (cnt == ex) {
                    answer++;
                }
            }

        }
        return answer;
    }
}





