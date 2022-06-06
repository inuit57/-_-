package com.test;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        Set<Integer> set = new HashSet<>();

        for(int i =0 ; i < n ; i++){
            int x= in.nextInt();
            if( set.contains(x) ){
                System.out.println("D");
                return;
            }
            set.add(x);
        }
        System.out.println("U");
        return ;
    }



}