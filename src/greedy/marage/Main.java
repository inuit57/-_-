package greedy.marage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n ;

    static class Time{
        int time;
        char stage;

        public Time(int time, char stage) {
            this.time = time;
            this.stage = stage;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0 ; i< n;i++){
            int s = in.nextInt();
            int e = in.nextInt();
            arr.add(new Time(s,'s'));
            arr.add(new Time(e,'e'));
        }

        System.out.println(solution(arr));

    }

    private static int solution(ArrayList<Time> arr){
        arr.sort((o1, o2) -> o1.time == o2.time? o1.stage-o2.stage : o1.time - o2.time);

        int answer = Integer.MIN_VALUE;
        int cnt =0 ;

        for(Time t : arr){
            if( t.stage == 's'){
                cnt ++;
            }else{
                cnt --;
            }
            answer = Math.max(cnt,answer);
        }

        return answer;
    }
}
