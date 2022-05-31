package com.test;

import java.util.*;

public class Main {


    public static void main(String[] args){
        Main T = new Main();
        Scanner in=new Scanner(System.in);

        int n = in.nextInt();
        
        // board 설정
        List<Queue<Integer>> board = new ArrayList<>() ;
        for(int i =0 ; i< n ;i++){
            board.add(new LinkedList<>());
        }

        // board 값 채우기 (Queue 에 저장)
        for(int i =0 ; i < n ; i++){
            for(int j =0 ; j< n ; j++){
                int input = in.nextInt();
                if(input != 0) {
                    board.get(j).add(input);
                }
            }
        }

        // moves 배열
        int m = in.nextInt();
        int[] moves = new int[m];
        for(int i =0 ; i< m ; i++){
            moves[i] = in.nextInt()-1;
        }

        /**
         List<Queue<Integer>> board
         int n
         int[] moves
         */
        System.out.println(T.solution(board, n, moves));

    }

    private int solution(List<Queue<Integer>> board, int n, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer =0 ;
        for(int i =0 ; i < moves.length; i++){
            int curr =0 ;
            if( !board.get(moves[i]).isEmpty()) {
                curr = board.get(moves[i]).remove();
            }
            if( !stack.isEmpty() && stack.peek() == curr){
                stack.pop();
                answer ++;
            }else {
                stack.push(curr);
            }
        }

        return answer*2;
    }

}