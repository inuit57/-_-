package stack.bj2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Tower{
        int height;
        int pos ;

        public Tower(int height, int pos){
            this.height = height;
            this.pos = pos;
        }

        public boolean isHigher(int height){
            return this.height < height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Stack<Tower> stk = new Stack<>();
        Tower max = new Tower(-1,-1);

        String s = br.readLine();
        String[] inputs = s.split(" ");

        for(int i =0 ; i< n ; i++){
            int height = Integer.parseInt(inputs[i]);
            // 최고 높이 갱신
            if( max.isHigher(height) ){
                max.height = height;
                max.pos = i+1;
                sb.append(0); // 앞 놈들보다 더 높으니까 0이 된다.
                stk.add(max);
            }else {
                while(!stk.isEmpty()){
                    if( !stk.peek().isHigher(height) ){
                        sb.append(stk.peek().pos);
                        break;
                    }else{
                        stk.pop(); // 스택 압축
                    }
                }
                stk.add(new Tower(height, i+1));
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }

}
