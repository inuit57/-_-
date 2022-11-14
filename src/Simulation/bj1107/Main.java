package Simulation.bj1107;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // 브루트 포스로 dfs 만들자 그럼
    static int depth ; // 최종 길이
    static int minValue = Integer.MAX_VALUE; // 찾으려는 답
    static int inputNumber  ;
    static boolean[] keys = new boolean[10] ;

    public void dfs(int idx, int number){
        if( idx > depth ){ // 종료조건
            minValue = Math.min( Math.abs(inputNumber - number), minValue);
            return;
        }

        // 각 자릿수 구하기
        int curr = Integer.toString(inputNumber).charAt(idx-1)-'0' ;

        for(int i =0 ; i< 10; i++){
            if(keys[i]){
                dfs(idx+1, number*10 + i);
            }
        }
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        String number = in.nextLine();
        depth = number.length();
        inputNumber =  Integer.parseInt(number);


        int n = in.nextInt();
        Arrays.fill(keys,true);

        for(int i=0; i< n ;i++){
            keys[in.nextInt()] = false;
        }

        int answer = 0 ;

        if( n == 10 || inputNumber == 100 ){
            answer =  Math.abs(inputNumber-100);
        }else {
            T.dfs(1, 0);
            answer = minValue + depth ;
        }
        System.out.println(answer);
    }

//    public int solution(String number, boolean[] keys, int n ){
//        int answer = 0;
//        int inputNumber = Integer.parseInt(number);
//
//        String[] split = number.split("");
//        StringBuilder sb = new StringBuilder();
//
//        if( n == 10 || inputNumber == 100 ){
//            return Math.abs(inputNumber-100);
//            // 100에서 수동으로 이동해야 한다.
//        }
//
//        // 하나라도 멀쩡한 버튼이 있다면
//        for(String s : split){
//            int curr = Integer.parseInt(s);
//            if( !keys[curr] ){
//                //curr = (curr+1)%10 ;
//                //curr = (curr-1)%10 ;
//            }
////            while(!keys[curr]){
////                //curr = (curr+1)%10 ; // 되는 버튼 찾기
////                // 위로 갈지 아래로 갈지?
////            }
//            sb.append(curr);
//            answer ++ ; // 자릿수만큼 증가시키기
//        }
//
//        answer += Math.abs(Integer.parseInt(sb.toString()) - inputNumber);
//        // Math.abs(Integer.parseInt(sb.toString()) - inputNumber);
//        // 결국 찾으려는 답은 이건데
//        return answer;
//    }



}
