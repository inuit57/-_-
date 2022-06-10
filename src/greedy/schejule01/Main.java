package greedy.schejule01;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int n;
    static class Lector implements Comparable<Lector>{
        // pQ에는 적용하지않는다.
        int money;
        int day;

        public Lector(int money, int day) {
            this.money = money;
            this.day = day;
        }

        @Override
        public int compareTo(Lector ob) {
            return ob.day - this.day;
        }
    }

    public int solution(ArrayList<Lector> arr){
        int answer= 0 ;
        // 기본은 작은 값을 우선순위로 한다. (오름차순)
        // 값이 들어갈 때마다 자동으로 정렬된다.
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr); //날짜에 의해서 내림차순 정렬 된다.

        int j= 0 ;
        for(int i = max ; i >0 ; i--){
            for( ; j< n ; j++ ){
                if( arr.get(j).day < i) break;
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        // 제일 마지막 날짜를 따로 저장할 것
        // 제일 큰 날짜부터 거꾸로 돌면서 처리할 것
        // 그리고 저장하는 순서는 날짜 기준 내림차순,
        // 날짜가 같다면 금액 순 내림차순으로 정렬
        ArrayList<Lector> arr = new ArrayList<>();

        for(int i =0 ; i< n; i++){
            int money = in.nextInt();
            int day = in.nextInt();
            arr.add(new Lector(money,day));
            // 가장 큰 날짜 계산하기
            max = Math.max(max,day);
        }

        System.out.println(T.solution(arr));

    }
}
