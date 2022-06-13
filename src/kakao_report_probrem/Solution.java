package kakao_report_probrem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 각 회원이 신고당한 횟수를 관리하기 위해서 추가하기
        Map<String, Integer> cntMap = new HashMap<>();

        // 어떤 사람들을 신고했는지 관리하기 위한 도구
        Map<String, ArrayList<String>> reporters = new HashMap<>();

        // 정보 초기화
        for(String str : id_list){
            reporters.put(str,new ArrayList<>());
            cntMap.put(str,0);
        }

        for(String rep : report){
            String[] split = rep.split(" ");
            String p1 = split[0]; // 제보자
            String p2 = split[1]; // 신고대상

            if(!reporters.get(p1).contains(p2)){ // 신고기록이 없을 때만 추가
                reporters.get(p1).add(p2);
                cntMap.put(p2, cntMap.getOrDefault(p2,0)+1); // 기존 횟수 + 1
            }
        }
        // 이렇게 하면 리포트 순회는 종료된다.

        for(int i =0 ; i< id_list.length; i++){
            String userName = id_list[i] ;
            int cnt = 0 ;
            for(String r : reporters.get(userName)){
                if( cntMap.get(r) >= k){
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
