package silverProb.pointFlatMap;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] origin = new int[n] ;


        HashMap<Integer, Integer> rankMap = new HashMap<>();

        for(int i =0 ; i< n; i++){
            origin[i] = in.nextInt();
        }

        int[] sorted = origin.clone();
        Arrays.sort(sorted);

        for(int i = 0 ; i< n ;i++){
            int key = sorted[i];
            if( !rankMap.containsKey(key)) {
                rankMap.put(key, i);
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i< n ; i++){
            sb.append(rankMap.get(origin[i])+" ") ;
        }

        System.out.println(sb);
    }

}
