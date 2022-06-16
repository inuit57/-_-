package dfs.inflean.maxScore01;

import java.util.Scanner;

class Score{
    int score ;
    int time;

    public Score(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class Main {
    static int n, timeLimit ;
    static Score[] scores ;
    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        timeLimit = in.nextInt();

        scores = new Score[n];
        for(int i =0 ; i < n; i++){
            int score = in.nextInt();
            int time = in.nextInt();
            scores[i] = new Score(score,time);
        }
        System.out.println(T.DFS(0,0,0));
    }

    private int DFS(int L, int sum, int time) {
        if(time > timeLimit) return -1;
        if( L >= n) return sum;
        return Math.max(
                DFS(L+1, sum+scores[L].score,time+scores[L].time),
                DFS(L+1, sum,time)

        );
    }
}
