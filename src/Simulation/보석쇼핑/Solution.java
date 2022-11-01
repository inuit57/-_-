package Simulation.보석쇼핑;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        //String[] input = {"A", "B" ,"B", "C", "A", "B", "C", "A","B","C"} ;
        String[] input = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"} ;

        Solution solution = new Solution();
        int[] answer = solution.solution(input);


    }

    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        // 슬라이딩 윈도우 or 투포인터로 풀어야 할 듯
        Set<String> gemSet = new HashSet<>();
        for(String g : gems){
            gemSet.add(g);
        }

        int gemCnt = gemSet.size(); // 갯수 확인

        int start = 0 ;
        int end = 0 ;
        // 결과 담는 용도의 map
        Map<Integer, String> resultMap = new HashMap<>();

        Map<String,Integer> gemMap = new HashMap<>();

        // 제일 끝까지 가는 경우도 있어서 +1 해줬다.
        for(int i = 0 ; i < gems.length +1 ; i++){
            while ( gemMap.size() == gemCnt ){ // 목표 달성
                // 현재 길이 정보 저장 하기
                StringBuilder sb = new StringBuilder();
                sb.append(start+1);
                sb.append(" ");
                sb.append(end+1);
                //resultMap.put(end-start, sb.toString());
                String curr = resultMap.getOrDefault(end-start,"");
                if( curr.compareTo(sb.toString()) > 0 || "".equals(curr)){
                    resultMap.put(end - start , sb.toString());
                }

                //gemSet.remove(sttGem) ;  // 시작 지점에 있던 것 제거
                String sttGem = gems[start];
                int nowCnt = gemMap.get(sttGem) -1 ;
                if( nowCnt < 1) gemMap.remove(sttGem);
                else gemMap.put(sttGem, nowCnt);

                start ++;
            }
            // 넣어주기
            if( i < gems.length ) {
                gemMap.put(gems[i], gemMap.getOrDefault(gems[i], 0) + 1);
                end = i;
            }

        }




        int min = resultMap.keySet().stream().min((o1, o2) -> o1 - o2).get();
        System.out.println("min " + min);
        System.out.println(resultMap.get(min));


        String[] ss = resultMap.get(min).split(" ");
        answer[0] = Integer.parseInt(ss[0]);
        answer[1] = Integer.parseInt(ss[1]);
        return answer;
    }
}
