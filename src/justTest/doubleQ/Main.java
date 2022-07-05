package justTest.doubleQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Function<String,Integer> parseInt = Integer::parseInt;

        int t = parseInt.apply(br.readLine());

        List<String> answerList = new ArrayList<>();

        for(int tkk = 0 ; tkk < t ; tkk++){
            int cnt = parseInt.apply(br.readLine());

            TreeMap<Integer,Integer> treeMap = new TreeMap<>();

            for(int cs =0 ; cs < cnt ; cs ++){
                String input = br.readLine();
                String[] splits = input.split(" ",2);
                if( "I".equals(splits[0])){
                    int num = parseInt.apply(splits[1]);
                    treeMap.put(num, treeMap.getOrDefault(num,0)+1);
                }else if(!treeMap.isEmpty()){
                    int key;
                    if("1".equals(splits[1])){
                        // 최댓값 삭제
                        key = treeMap.lastKey();
                    }else{
                        key = treeMap.firstKey();
                    }
                    treeMap.put(key, treeMap.getOrDefault(key,1)-1);
                    if( treeMap.get(key) == 0 ){
                        treeMap.remove(key);
                    }
                }
            }
            if( treeMap.isEmpty()){
                answerList.add("EMPTY");
            }else{
                answerList.add( treeMap.lastKey() + " " + treeMap.firstKey());
            }
        } // tkk

        for(String answer : answerList){
            System.out.println(answer);
        }

    }

}
