package union_find.bj1043;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n,m;

    static int[] unf ;

    static int find(int v){
        if( unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }

    static void union(int a,int b){
        int x = find(a);
        int y = find(b);
        if( x != y ){
            unf[x] = y;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        n = in.nextInt();
        m = in.nextInt();
        unf = new int[n+1] ;

        for(int i=1 ; i< n+1; i++){
            unf[i] = i;
        }

        int t = in.nextInt();
        if( t == 0){
            System.out.println(m);
            return;
        }

        // 초기 아는 놈들 설정하기
        int before = in.nextInt();
        unf[before] = 0 ;
        for(int i=1; i< t; i++){
            int next = in.nextInt();
            union(before, next);
            before = next;
        }

        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();

        boolean flag = false ;
        for(int i=0; i< m ;i++){
            int gn = in.nextInt(); // 그룹 인원 숫자

            ArrayList<Integer> arr = new ArrayList<>();
            before = in.nextInt();
            arr.add(before);

            for(int j=1; j< gn ; j++){
                int next = in.nextInt();
                arr.add(next);
                union(before,next);
                next = before;
                // 같은 그룹에 속한 것들은 union 으로 묶어주자
            }

            inputs.add(arr);
            flag = false;
        }

        // 허풍 떨지 정하기
        int answer = inputs.size();
        for(ArrayList<Integer> numbers : inputs){
            for(int num : numbers){
                if( find(num) != num ){
                    answer --;
                    break;
                }
            }
        }

        System.out.println(answer);

    }

}
