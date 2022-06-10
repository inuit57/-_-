package greedy.schejule01;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;
        for(int i =0 ; i< n; i++){
            int pay = in.nextInt();
            int day = in.nextInt();
            if( !map.containsKey(day)){
                // 해당 날짜가 없는 경우
                map.put(day,new ArrayList<>());
            }
            map.get(day).add(pay);
            minDay = Math.min(day,minDay);
            maxDay = Math.max(day,maxDay);
        }

        for(int key : map.keySet()){
            // 정렬 , 큰 순서대로
            map.get(key).sort(Collections.reverseOrder());
        }

        // key 들도 정렬하기
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);

        int sum =0 ;
        for(int d= maxDay ; d >= minDay ; d-- ){  // 반대로 해보자.
            int max = Integer.MIN_VALUE ;
            int max_idx = -1 ;
            for(int key : keyList){
                if(key < d) continue;
                if( (!map.get(key).isEmpty()) &&
                        (max < map.get(key).get(0))){
                    max_idx = key;
                    max = map.get(key).get(0);
                }
            }
            if( max_idx >=0 ) {
                sum += map.get(max_idx).remove(0); // 제일 컸던 놈 제거
            }
        }

        System.out.println(sum);
    }
}
