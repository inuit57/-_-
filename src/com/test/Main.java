package com.test;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        Set<Integer> arr1 = new HashSet<>();
        for(int i =0 ; i< input1; i++){
            arr1.add(in.nextInt());
        }

        int input2 = in.nextInt();
        List<Integer> answer = new ArrayList<>();
        for(int i =0 ; i< input2; i++){
            int tmp = in.nextInt();
            if( arr1.contains(tmp)){
                //System.out.print(tmp +" ");
                answer.add(tmp);
            }
        }

        Collections.sort(answer);
        for(int ans : answer){
            System.out.print(ans +" ");
        }


    }



}





