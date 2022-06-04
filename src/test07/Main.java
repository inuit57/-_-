package test07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        String requiredSub = in.next();
        String planedSub = in.next();

        System.out.println(T.solution(requiredSub,planedSub));
    }

    private String solution(String requiredSub, String planedSub) {

        Queue<Character> requiredQueue = new LinkedList<>();
        for(char x : requiredSub.toCharArray()){
            requiredQueue.offer(x);
        }

        for(char x : planedSub.toCharArray()){
            if(requiredQueue.contains(x)){
                if(requiredQueue.peek() == x){
                    requiredQueue.poll();
                }else{
                    return "NO";
                }
            }else{
                continue;
            }

        }

        return "YES";
    }
}
