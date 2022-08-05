package Simulation.포켓몬도감;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        HashMap<String, Integer>  nameMap = new HashMap<>();
        HashMap<Integer, String>  numMap = new HashMap<>();
        for(int i =1; i<= N ; i++){
            String name = in.next();
            nameMap.put(name, i);
            numMap.put(i, name);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i< M ; i++){
            String input = in.next();
            int answer = nameMap.getOrDefault(input , 0);
            if( answer != 0 ){
                sb.append(answer);
            }else{
                // input 은 숫자값
                sb.append(numMap.get(Integer.parseInt(input)));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
