package dfs.programers.던전;

public class Main {
    static boolean[] isVisit ;
    static int maxCnt = 0 ;

    public static void main(String[] args){
        Main m = new Main();
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        // 문제점
        // 다른 곳을 들렀다가 이전 위치에 있는 것을 탐색해야할 수도 있다.
        // 정방향 탐색 말고도 역방향으로도 탐색을 돌려야할지도

        int answer = m.solution(k, dungeons);
        System.out.println(answer);
    }

    public int solution(int k, int[][] dungeons){
        isVisit = new boolean[dungeons.length];

        dfs(k,dungeons,0);

        return maxCnt;
    }

    public void dfs(int k, int[][] dungeons, int depth   ) {
        for(int i=0; i< dungeons.length ; i++){
            if( k >= dungeons[i][0] && !isVisit[i] ){
                isVisit[i] = true;
                dfs(k - dungeons[i][1],dungeons,depth+1);
                isVisit[i] = false;
            }
        }
        maxCnt = Math.max(maxCnt,depth);
    }
}
