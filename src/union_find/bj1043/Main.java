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


        n = in.nextInt();
        m = in.nextInt();
        unf = new int[n+1] ;

        for(int i=1 ; i< n+1; i++){
            unf[i] = i;
        }

        int answer = m;
        int t = in.nextInt();

        int xman ;

        if( t != 0 ) {
            // 초기 아는 놈들 설정하기
            int before = in.nextInt();
            for (int i = 1; i < t; i++) {
                int next = in.nextInt();
                union(before, next);
                before = next;
            }
            xman = before; // 나중에 확인 용도

            ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int gn = in.nextInt(); // 그룹 인원 숫자

                ArrayList<Integer> arr = new ArrayList<>();
                before = in.nextInt();
                arr.add(before);

                for (int j = 1; j < gn; j++) {
                    int next = in.nextInt();
                    arr.add(next);
                    union(before, next);
                    before = next;
                    // 같은 그룹에 속한 것들은 union 으로 묶어주자
                }

                inputs.add(arr);
            }

//            printUF();

            // 허풍 떨지 정하기
            for (ArrayList<Integer> numbers : inputs) {
                for (int num : numbers) {
                    if (find(num) == find(xman)) {
                        answer--;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);

    }

    private static void printUF() {
        for(int i = 1; i< n+1; i++){
            System.out.println(i + " : " + find(i));
        }
    }

}
