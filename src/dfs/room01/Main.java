package dfs.room01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 회의실 문제
 */
public class Main {

    static class Room{
        int start;
        int end;
        Room(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    static boolean[] chk ;

    static ArrayList<Room> rooms = new ArrayList<>();
    static int n ;
    static int answer ;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        chk = new boolean[n];
        answer = 0;
        for(int i =0; i< n; i++){
            rooms.add(new Room(in.nextInt(),in.nextInt()));
        }
        // 끝나는 시간으로 오름차순 정렬,
        // 단, 같은 경우에는 시작시간으로 오름차순으로 정렬할 것.
        rooms.sort( (o1,o2)-> o1.end == o2.end ? o1.start - o2.start : o1.end - o2.end);
        T.DFS(0,0);
        System.out.println(answer);
    }

    private void DFS(int L, int end) {
        if(L > n) return;
        if( L == n){
            int cnt =0 ;
            for(int i =0 ; i< n ;i++){
                if(chk[i]) cnt++ ;
            }
            answer = Math.max(answer,cnt);
        }else{
            if(!chk[L]){
                // 넣을 수 있는지 판단이 필요하다.
                if( end <= rooms.get(L).start){
                    chk[L] = true;  //넣는 것 가능
                    DFS(L+1, rooms.get(L).end);
                    chk[L] = false;
                }
                DFS(L+1, end); // 넣지 않는 경우 + 못 넣는 경우
            }
        }
    }
}
