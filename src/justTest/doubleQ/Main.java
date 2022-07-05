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
            PriorityQueue<Integer> ascQ = new PriorityQueue<>();
            PriorityQueue<Integer> descQ = new PriorityQueue<>(Collections.reverseOrder());

            for(int cs =0 ; cs < cnt ; cs ++){
                String input = br.readLine();
                String[] splits = input.split(" ",2);
                if( "I".equals(splits[0])){
                    int num = parseInt.apply(splits[1]);
                    ascQ.add(num);
                    descQ.add(num);
                }else{
                    int deleteNum ;
                    if("1".equals(splits[1])){
                        // 최댓값 삭제
                        if( !descQ.isEmpty() ) {
                            deleteNum = descQ.poll();
                            ascQ.remove(deleteNum);
                        }
                    }else{
                        if( !ascQ.isEmpty() ) {
                            deleteNum = ascQ.poll();
                            descQ.remove(deleteNum);
                        }
                    }
                }
            }
            if( descQ.isEmpty() ){
                answerList.add("EMPTY");
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append(descQ.poll());
                sb.append(" ");
                sb.append(ascQ.poll());
                answerList.add(sb.toString());
            }
        } // tkk

        StringBuilder sb = new StringBuilder();
        for(String str : answerList){
            //System.out.println(str);
            sb.append(str);
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
