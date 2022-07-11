package stack.bj2812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputs = br.readLine();
        String[] s = inputs.split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]) + 1;

        String number = br.readLine();
        Stack<Integer> stk = new Stack<>();

        stk.push(0);

        for(int ch : number.toCharArray()){
            ch-='0';
            if(k == 0|| ch == stk.peek() ) stk.push(ch);
            else if( ch > stk.peek() ){
                stk.pop();
                stk.push(ch);
                k--;
            }else{
                k--; // 아예 넣지도 않기.
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < stk.size(); i++){
            sb.append(stk.get(i));
        }
        System.out.println(sb);

    }
}
