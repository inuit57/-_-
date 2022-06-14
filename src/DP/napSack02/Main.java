package DP.napSack02;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class Score{
        public Score(int score, int time) {
            this.score = score;
            this.time = time;
        }

        int score ;
        int time ;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        int n = in.nextInt();
        int time = in.nextInt();

        // dy[j] = j분 동안 풀 수 있는 최대점수
        ArrayList<Score> scores = new ArrayList<>();
        for(int i=0 ; i<n ;i++){
            scores.add(new Score(in.nextInt(),in.nextInt()));
        }

        System.out.println(T.solution(time, scores));
    }

    public int solution(int timeLimit, ArrayList<Score> scores){
        int dy[] = new int[timeLimit+1] ;
        // 앞에서부터 하는게 아니라 뒤에서부터 계산하면
        // 중복을 피할 수가 있다.
        for(Score score : scores){
            for(int i = timeLimit ; i>= score.time ; i--){
                dy[i] = Math.max(dy[i], dy[i-score.time]+score.score);
            }
        }
        return dy[timeLimit];
    }
}
