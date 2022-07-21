package dfs.bj.bj2644;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // 전체 사람의 수
        int[] pp = new int[n+1];

        // 전략
        // 한쪽에서 부모 노드가 확인 될 때마다 pp에 촌수를 기록한다.
        // 그리고 다른 한쪽에서 부모 노드가 확인 될 때
        // pp 에 0이 아닌 값이 저장되어있다고 한다면 그 값을
        // 현재까지 고려된 촌수를 더해서 반환한다.

        // 전략을 바꾸자. bfs 로 가야할 수도 있겠다.
        // 뭔가 내가 놓치고 있는 부분이 있을 수도 있다.

        // check 배열을 만들자.
        // 그리고 부모와 내 자식들을 큐에 모조리 담아버리자.
        // 그렇게 해서 큐가 빌 떄까지 찾도록 하는 거다.
        // 그 편이 좀더 확실하고 좋다고 느껴지네.

        int start = in.nextInt();
        int end = in.nextInt();

        if( start == end ){
            System.out.println(0);
            return;
        }

        int k = in.nextInt(); // 입력 받기 시작
        // 부모 자식 순서로 입력된다.
        // 이것을 어떻게 저장할지를 좀 고민해야 한다.

        int[][] map = new int[n+1][n+1];

        for(int i = 0; i< k; i++){
            int parent = in.nextInt();
            int child = in.nextInt();

            map[child][parent] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int answer = bfsSolution(n, end, map, queue);
        //answer = treeMapSolution(in, pp, start, end, k);

        System.out.println(answer);
    }

    private static int bfsSolution(int n, int end, int[][] map, Queue<Integer> queue) {

        int[] check = new int[n+1] ;
        int L = 0;
        while(!queue.isEmpty()){
            L++;
            int size = queue.size();
            for(int i=0 ; i< size; i++){
                Integer poll = queue.poll();
                if( poll != null) {
                    int q = poll;

                    for (int j = 1; j <= n; j++) {
                        if (map[q][j] == 1 && check[j] != 1) {
                            check[j] = 1;
                            if (j == end) return L;
                            queue.add(j); // 항목 추가
                        }
                        if (map[j][q] == 1 && check[j] != 1) {
                            check[j] = 1;
                            if (j == end) return L;
                            queue.add(j); // 항목 추가
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static int treeMapSolution(Scanner in, int[] pp, int start, int end, int k) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        for(int i = 0; i< k; i++){
            int parent = in.nextInt();
            int child = in.nextInt();

            treeMap.put(child,parent);
            // child 는 중복되지 않는다.
            // 각 사람의 부모가 하나니까.
        }


        int index = 1;
        int child = start;
        while(treeMap.containsKey(child)){
            int parent = treeMap.get(child);
            pp[parent] = index;
            child = parent;
            index ++; // 촌수 증가
        }

        int answer = -1;
        index = 1;
        child = end;
        while(treeMap.containsKey(child)){
            int parent = treeMap.get(child);
            if( pp[parent] != 0){
                answer = pp[parent] + index;
                break;
            }
            if( parent == start){
                answer = index;
                break;
            }
            pp[parent] = index;
            child = parent;
            index ++; // 촌수 증가
        }
        return answer;
    }


}
