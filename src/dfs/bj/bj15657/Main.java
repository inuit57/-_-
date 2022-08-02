package dfs.bj.bj15657;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] arr ;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();
        arr = new int[N];

        for(int i =0; i<N ; i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr); // 오름차순으로 정렬

        // 백트래킹을 해야 한다.
        // 중복 순열 만들기
        // 출력도 제때 제때 해줘야 하고 말이지
        // 출력양이 길어질 수도 있으니까 StringBuilder 를 쓰는 것이 좋을 듯.

        answer(0,0  );

        System.out.println(sb.toString());

        in.close();
    }

    private static void answer( int curr, int count   ){
        if( curr >= N) return;

        if( count == M){
            sb.append("\n");
            return;
        }
        sb.append(arr[curr]);
        sb.append(" ");

        answer(curr, count+1 ); // 현재 위치를 다시 선택하는 경우
        answer(curr+1, count  ); // 현재 위치를 선택하지 않는 경우
    }
}
