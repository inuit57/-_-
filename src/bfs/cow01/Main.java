package bfs.cow01;


import java.util.*;


public class Main {
    Set<Integer> chk = new HashSet<>();
    int[] dis = {1,-1,5};
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int pos, int obj){
        // 최단 거리 알고리즘 : BFS로 푼다.
        Q.offer(pos);
        chk.add(pos);
        // 기본값 세팅

        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i =0 ; i< len ; i++){
                int ex = Q.poll();
                if( ex == obj ) return L;

                for(int k: dis){
                    int newPos = ex+k;
                    if(!chk.contains(newPos)){
                        Q.offer(newPos);
                        chk.add(newPos);
                    }
                }
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        int pos = in.nextInt();
        int obj = in.nextInt();

        System.out.println(T.BFS(pos, obj));
    }
}
