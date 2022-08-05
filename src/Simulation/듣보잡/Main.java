package Simulation.듣보잡;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        HashSet<String> set = new HashSet<>();
        LinkedList<String> list = new LinkedList<>();

        int n = in.nextInt();
        int m = in.nextInt();
        String name = null;
        for(int i =0 ; i< n ;i++){
            name = in.next();
            set.add(name);
        }

        for(int i=0 ; i < m ; i++){
            name = in.next();
            if(set.contains(name)){
                list.add(name);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        int size = list.size() ;
        sb.append(size);
        sb.append("\n");
        for(int i =0; i<size ; i++){
            sb.append(list.get(i));
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
