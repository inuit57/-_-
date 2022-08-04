package bfs.bj.숨바꼭질1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int start = in.nextInt();
        int obj = in.nextInt();

        //System.out.println(T.solution(start,obj));
        T.solution(start,obj);
    }

    private int solution(int start, int obj) {
//        boolean[] visit = new boolean[100001];
        int[] visit = new int[100001];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visit[start] = start;

        int answer = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i< size ; i++){
                int curr = queue.poll();
                if( curr == obj ){
                    StringBuilder sb = new StringBuilder();

                    ArrayList<Integer> arr = new ArrayList<>();
                    int before = visit[obj];
                    arr.add(obj);
                    arr.add(before);
                    while( visit[before] != start){
                        before = visit[before];
                        arr.add(before);
                    }
                    arr.add(start);

                    Collections.reverse(arr);
                    for(int a : arr){
                        sb.append(a);
                        sb.append(" ");
                    }

                    System.out.println(answer);
                    System.out.println(sb);

                    return answer;
                }

                int next = curr-1;
                if( next >= 0 &&  visit[next] == 0  ){
                    queue.add(next);
                    visit[next] = curr;
                }
                next = curr +1;
                if( next <= 100000 && visit[next] == 0 ){
                    queue.add(next);
                    visit[next] = curr;
                }
                next = curr*2 ;
                if( next <= 100000 &&  visit[next] == 0 ){
                    queue.add(next);
                    visit[next] = curr;
                }
            }
            answer++;
        }

        return -1; // 도달 불가능.
    }

}
