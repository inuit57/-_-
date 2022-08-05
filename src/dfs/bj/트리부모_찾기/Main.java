package dfs.bj.트리부모_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i, j;

        // 입력의 크기가 큰 경우에는 NxN 배열을 선언할 경우
        // 메모리가 터질 수 있으니까 인접리스트로 접근하는 것이 좋다.
        
        // 연결 정보
        ArrayList<Integer>[] list = new ArrayList[n+1];
        // 초기화
        for(i=1; i<=n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        // 연결
        for(i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        // 결과 값(부모값)
        // 예: parents[i] = j (i의 부모 : j)

        // 맵에 저장하는 것을 생각했는데 그냥 1차원 배열에 저장하였더라도
        // 크게 문제가 없었을 듯 싶다. 둘다 어짜피 int 값이기도 하고.
        int[] parents = new int[n+1];

        // dfs
        dfs(list, parents, n, 1, 0);

        // 결과 출력
        for(j=2;j<=n; j++) System.out.println(parents[j]);
    }

    private static void dfs(ArrayList<Integer>[] list, int[] parents, int n, int start, int parent) {
        parents[start] = parent;
        for(int item : list[start]) {
            if(item != parent) dfs(list, parents, n, item, start);
        }
    }

}
