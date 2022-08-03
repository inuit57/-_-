package Simulation.숫자카드2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0 ; i < N ; i++){
            int key = in.nextInt();
            map.put(key, map.getOrDefault(key,0)+1);
        }

        StringBuilder sb = new StringBuilder();
        int M = in.nextInt();
        for(int i =0 ; i< M; i++){
            sb.append(map.getOrDefault(in.nextInt(),0));
            sb.append(" ");
        }

        System.out.println(sb);

    }

}
