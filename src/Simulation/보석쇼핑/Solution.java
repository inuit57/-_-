package Simulation.보석쇼핑;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        String[] input = {"AA", "AB", "AC", "AA", "AC"} ;

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

        for(int i = 0 ; i < gems.length ; i++){
            if( gemMap.size() == gemCnt ){ // 목표 달성
                // 현재 길이 정보 저장 하기
                StringBuilder sb = new StringBuilder();
                sb.append(start+1);
                sb.append(" ");
                sb.append(end+1);
                resultMap.put(end-start, sb.toString());

                //gemSet.remove(sttGem) ;  // 시작 지점에 있던 것 제거
                String sttGem = gems[start];
                int nowCnt = gemMap.get(sttGem) -1 ;
                if( nowCnt < 1) gemMap.remove(sttGem);
                else gemMap.put(sttGem, nowCnt);

                start ++;
            }else{
                // 넣어주기
                gemMap.put(gems[i], gemMap.getOrDefault(gems[i],0)+1);
                end = i ;
            }
        }

        while (gemMap.size() == gemCnt){
            String sttGem = gems[start];
            // 현재 길이 정보 저장 하기
            StringBuilder sb = new StringBuilder();
            sb.append(start+1);
            sb.append(" ");
            sb.append(end+1);
            resultMap.put(end-start, sb.toString());

            //gemSet.remove(sttGem) ;  // 시작 지점에 있던 것 제거
            int nowCnt = gemMap.get(sttGem) -1 ;
            if( nowCnt < 1) gemMap.remove(sttGem);
            else gemMap.put(sttGem, nowCnt);

            start ++;
        }


        int min = resultMap.keySet().stream().min((o1, o2) -> o1 - o2).get();
        //System.out.println("min " + min);
        //System.out.println(resultMap.get(min));


        String[] ss = resultMap.get(min).split(" ");
        answer[0] = Integer.parseInt(ss[0]);
        answer[1] = Integer.parseInt(ss[1]);
        return answer;
    }
}
