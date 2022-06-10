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

        /**
         * 다음 방 신청자가 사용할 수 있는지 파악
         * @param room : 다음 방 신청 정보 
         * @return : 사용 가능 여부 리턴
         */
        public boolean isPossible(Room room){
            return this.end <= room.start ;
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
        // 시작 시간 순서로 정렬해서 제공할 필요가 있어 보인다.
        rooms.sort(Comparator.comparingInt(room-> room.start));
        T.DFS(0,0);
        System.out.println(answer);
    }

    private void DFS(int L, int end) {
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
