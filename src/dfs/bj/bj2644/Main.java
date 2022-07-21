package dfs.bj.bj2644;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int n = in.nextInt(); // 전체 사람의 수
        int[] pp = new int[n+1];

        // 전략
        // 한쪽에서 부모 노드가 확인 될 때마다 pp에 촌수를 기록한다.
        // 그리고 다른 한쪽에서 부모 노드가 확인 될 때
        // pp 에 0이 아닌 값이 저장되어있다고 한다면 그 값을
        // 현재까지 고려된 촌수를 더해서 반환한다.

        int start = in.nextInt();
        int end = in.nextInt();

        int k = in.nextInt(); // 입력 받기 시작
        // 부모 자식 순서로 입력된다.
        // 이것을 어떻게 저장할지를 좀 고민해야 한다.

        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        for(int i =0 ; i< k ; i++){
            int parent = in.nextInt();
            int child = in.nextInt();

            treeMap.put(child,parent);
            // child 는 중복되지 않는다.
            // 각 사람의 부모가 하나니까.
        }

        int index = 1;
        int child = start;
        while(treeMap.containsKey(child)){
            int parent = treeMap.get(child);
            pp[parent] =index;
            child = parent;
            index ++; // 촌수 증가
        }

        int answer = -1;
        index = 1;
        child = end;
        while(treeMap.containsKey(child)){
            int parent = treeMap.get(child);
            if( pp[parent] != 0){
                answer = pp[parent] + index;
                break;
            }
            pp[parent] =index;
            child = parent;
            index ++; // 촌수 증가
        }

        System.out.println(answer);
    }


}
