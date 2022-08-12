package stack.검열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String keyStr = br.readLine();

        int keyLen = keyStr.length();
        StringBuilder targetStr = new StringBuilder(br.readLine());

        boolean isLeft = true;

        // 투포인터 사용, Deque 로 풀어야 한다는데,
        // 감이 잘 잡히진 않는다. 다음에 다시 시도해보자.

        while(true){
            if(isLeft){
                int pos = targetStr.indexOf(keyStr);
                if( pos > -1){
                    targetStr.delete(pos,pos+keyLen);
                    isLeft = false;
                }else{
                    break;
                }
            }else{
                int pos = targetStr.lastIndexOf(keyStr);
                if(pos >-1){
                    targetStr.delete(pos, pos+keyLen);
                    isLeft = true;
                }else{
                    break;
                }
            }
        }

        System.out.println(targetStr);
    }


}
