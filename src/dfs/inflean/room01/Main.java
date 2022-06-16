package dfs.inflean.room01;

import java.util.ArrayList;
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

    static ArrayList<Room> rooms = new ArrayList<>();
    static int n ;
    static int answer ;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        answer = 0;
        for(int i =0; i< n; i++){
            rooms.add(new Room(in.nextInt(),in.nextInt()));
        }
        // 끝나는 시간으로 오름차순 정렬,
        // 단, 같은 경우에는 시작시간으로 오름차순으로 정렬할 것.
        rooms.sort( (o1,o2)-> o1.end == o2.end ? o1.start - o2.start : o1.end - o2.end);

        System.out.println(T.solution(rooms,n));
    }

    private int solution(ArrayList<Room> arr, int n){
        int cnt = 0 ;
        int et = 0 ;
        for(Room r : arr){
            if(r.start >= et){
                cnt++;
                et = r.end;
            }
        }
        return cnt;
    }


}
