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
