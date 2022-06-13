package bfs.wordChange;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main T = new Main();
        String begin = "hit";
        String target= "cog";

        String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};

        int a = T.solution(begin,target,words);
        System.out.println(a);
    }

    public boolean isChangeable(String a, String b){
        int cnt = 0 ;
        for(int i =0 ; i< a.length() ; i++ ){
            if( a.charAt(i) != b.charAt(i)){
                cnt ++ ;
                if( cnt > 1) return false;
            }
        }
        return true;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 1;

        // 단어가 없다면(!contains()) 바로 0 리턴
        // Queue 를 사용해서 BFS 로 풀이하는 편이 좋아보인다.
        // target 단어를 찾으면 거기에서 바로 멈추도록 한다. (자동으로 최소길이가 된다.)
        ArrayList<String> list = new ArrayList<>();
        for(String str : words){
            list.add(str);
        }

        if( !list.contains(target)) return 0;

        boolean[] check = new boolean[words.length];

        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);

        while(!queue.isEmpty()){
            String lastWord = queue.poll();

            if (lastWord.equals(target)) return answer+1;
            for (int j =0 ; j< words.length ; j++) {
                if (!check[j] && isChangeable(lastWord, words[j])) {
                    queue.offer(words[j]);
                    check[j] = true;
                }
            }

            answer ++ ;
        }

        return 0;
    }

}
