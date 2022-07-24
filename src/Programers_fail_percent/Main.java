package Programers_fail_percent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] answer = T.solution(N, stages);
        for (int i : answer) {
            System.out.println(i);
        }

    }

    class StageInfo{
        int stageNo ;
        int fail_per ;

        StageInfo(int stageNo, double fail_per){
            this.stageNo = stageNo;
            this.fail_per = (int)(fail_per *1000);
        }
    }

    public int[] solution(int N, int[] stages) {

        // 1 ~ N 까지만 검사할 예정
        // N+1 : 다 깬 놈도 그냥 처리하려고 N+2 로 설정
        int[] notClears = new int[N+2];

        int totUser = stages.length; // 전체 사람수

        for(int stage: stages){
            notClears[stage]++;
        }

        // 실패율 계산
        // notClears[i] / (totUser - notClears[i])
        // 깬 놈들은 저 배열에 기록되지 않는다.

        // https://school.programmers.co.kr/learn/courses/30/lessons/42889

        // 이거를 이제 어떻게 이쁘게 가공해서 정렬할까 라는 거지.
        List<StageInfo> stageInfoList = new ArrayList<>();
        for(int i=1; i<= N; i++){
            int real_tot = totUser;
            for(int j=1; j< i; j++){
                real_tot -= notClears[j];  // 이 단계까지 오지 못한 사람들 빼주기
            }
            double failPercent = (double)(notClears[i]) / real_tot ;
            stageInfoList.add(new StageInfo(i,failPercent));
        }

        stageInfoList.sort(new Comparator<StageInfo>() {
            @Override
            public int compare(StageInfo o1, StageInfo o2) {
                if( o1.fail_per == o2.fail_per){
                    return o1.stageNo - o2.stageNo    ;
                }else{
                    return o2.fail_per - o1.fail_per  ;
                }
            }
        });



        int[] answer = stageInfoList.stream().mapToInt(stageInfo -> stageInfo.stageNo).toArray();
        return answer;
    }

}
