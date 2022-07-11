package stack.bj9935;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        String str = in.nextLine();
        String bomb = in.nextLine();

        int start = 0;
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            stack.push(ch);
            if( stack.size() - start == bomb.length() ){
                for(int b = 0 ; b<bomb.length() ; b++){
                    if(stack.get(b+start) != bomb.charAt(b)){
                        flag = false;
                    }
                }
                if( flag ){
                    for(int b = 0 ; b < bomb.length(); b++){
                        stack.pop();
                    }
                    start -=(bomb.length()-1);
                    if( start < 0) start = 0;
                }else{
                    flag = true;
                    start ++;
                }
            }
        }

        if( stack.isEmpty() ) System.out.println("FRULA");
        else{
            StringBuilder sb = new StringBuilder();
            for(int i =0 ; i< stack.size() ; i++){
                sb.append(stack.get(i));
            }
            System.out.println(sb);
        }

    }

}
