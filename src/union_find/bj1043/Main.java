package union_find.bj1043;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n,m;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        n = in.nextInt();
        m = in.nextInt();

        int t = in.nextInt();
        if( t == 0){
            System.out.println(m);
            return;
        }

        boolean[] peoples = new boolean[n+1];
        for(int i=0; i< t; i++){
            peoples[in.nextInt()] = true;
        }

        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();

        for(int i=0; i< m ;i++){
            int gn = in.nextInt();

            boolean flag = false;
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0; j< gn ; j++){
                int next = in.nextInt();
                if( peoples[next] ) flag = true;
                arr.add(next);
            }
            if( flag ){
                // 진실을 알고 있는 놈들도 다 때려넣어주자
                for(int ab : arr){
                    peoples[ab] = true;
                }
            }else {
                // 해당되지 않는 것만 집어넣자
                inputs.add(arr);
            }
            flag = false;
        }

        int answer = inputs.size();
        for(ArrayList<Integer> numbers : inputs){
            for(int num : numbers){
                if( peoples[num] ){
                    answer --;
                    break;
                }
            }
        }

        System.out.println(answer);

    }

}
