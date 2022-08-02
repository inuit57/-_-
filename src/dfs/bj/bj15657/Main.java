package dfs.bj.bj15657;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] arr ;
    static boolean[] visit ;
    static StringBuilder sb = new StringBuilder();
    static int[] resultArray;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        N = in.nextInt();
        M = in.nextInt();
        arr = new int[N];
        visit = new boolean[N];
        resultArray = new int[M];

        for(int i =0; i<N ; i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr); // 오름차순으로 정렬

        // 백트래킹을 해야 한다.
        // 중복 순열 만들기
        // 출력도 제때 제때 해줘야 하고 말이지
        // 출력양이 길어질 수도 있으니까 StringBuilder 를 쓰는 것이 좋을 듯.

        T.DFS(0);

        System.out.println(sb.toString());

        in.close();
    }

    private void DFS(int depth) {
        if (depth == M) {
            for(int x : resultArray){
                sb.append(x);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i =0 ; i< N ;i++){
            // 앞보다 더 작은 경우 건너뛰기
            //if( depth > 0  && resultArray[depth-1] > arr[i]) continue;
            if(!visit[i]) {
                visit[i] = true;
                resultArray[depth] = arr[i];
                DFS(depth + 1);
                visit[i] = false;
            }
//            else{
//                resultArray[depth] = arr[i]; // 중복순열용
//                DFS(depth+1);
//            }
        }
    }
}
