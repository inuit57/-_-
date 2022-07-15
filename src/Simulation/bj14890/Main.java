package Simulation.bj14890;

import java.util.Scanner;

public class Main {


    // visit 배열을 사용해서 방문 체크를 확실하게 하는 것으로 수정해봅시다.
    // 그게 가장 확실하게 체크하는 방식이 되지 않을까 싶네요.

    // 한 줄씩 체크하도록 하고, visited[] 1차원 배열을 놓아서 처리하는 게 좋을 듯 합니다.
    // 길이가 1일 때, 되게 체크하기가 애매한 부분들이 많네요. visit 배열로 처리를 좀 돕는 편이 좋아보입니다.
    /*

    3 1
6 6 6
5 5 6
5 6 6
    답 : 5
    내 코드 : 6
-> 이거 테스트 필요.


6 1
5 3 3 4 6 6
5 4 3 4 6 6
4 3 3 4 5 5
3 3 3 4 4 4
3 3 3 3 4 4
5 3 3 4 5 5
    답 : 7
    내 코드 : 8

     */

    static int[][] map;
    static int N, L ;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        L = in.nextInt();

        // 값 저장
        map = new int[N][N];
        makeMap(in, N, map);


        int answer= 0;
        for(int i =0 ; i< N ; i++){
            if( calRow(i) ) answer ++;
            if( calCol(i) ) answer ++;
        }

        System.out.println(answer);

    }

    private static void makeMap(Scanner in, int N, int[][] map) {
        for(int i = 0; i< N; i++){
            for(int j = 0; j< N; j++){
                map[i][j] = in.nextInt();
            }
        }
    }

    public static boolean calRow(int row) {
        boolean[] isIncline = new boolean[N]; //경사면 설치 여부를 확인하는 배열

        for(int i = 0; i < N - 1; i++) {
            int diff = map[row][i] - map[row][i + 1];

            if(diff > 1 || diff < -1) return false; //높이차 1 초과하므로 false
            else if(diff == -1) { // 다음 계단이 한 계단 높다
                for(int j = 0; j < L; j++) { // 올라가는 경사로를 설치할 수 있는지 확인한다.
                    if(i - j < 0 || isIncline[i - j]) return false;
                    if(map[row][i] != map[row][i - j]) return false;
                    isIncline[i - j]  = true; //경사면 설치
                }
            }
            else if(diff == 1) { //다음 계단이 한 계단 낮다
                for(int j = 1; j <= L; j++) { //내려가는 경사로를 설치할 수 있는지 확인한다.
                    if(i + j >= N || isIncline[i + j]) return false;
                    if(map[row][i] - 1 != map[row][i + j]) return false;
                    isIncline[i + j] = true; //경사면 설치
                }
            }
        }
        return true;
    }

    public static boolean calCol(int col) {
        boolean[] isIncline = new boolean[N]; //경사면 설치 여부를 확인하는 배열

        for(int i = 0; i < N - 1; i++) {
            int diff = map[i][col] - map[i + 1][col];

            if(diff > 1 || diff < -1) return false; //높이차 1 초과하므로 false
            else if(diff == -1) { // 다음 계단이 한 계단 높다
                for(int j = 0; j < L; j++) { // 올라가는 경사로를 설치할 수 있는지 확인한다.
                    if(i - j < 0 || isIncline[i - j]) return false;
                    if(map[i][col] != map[i - j][col]) return false;
                    isIncline[i - j]  = true; //경사면 설치
                }
            }
            else if(diff == 1) { //다음 계단이 한 계단 낮다
                for(int j = 1; j <= L; j++) { //내려가는 경사로를 설치할 수 있는지 확인한다.
                    if(i + j >= N || isIncline[i + j]) return false;
                    if(map[i][col] - 1 != map[i + j][col]) return false;
                    isIncline[i + j] = true; //경사면 설치
                }
            }
        }
        return true;
    }
}
