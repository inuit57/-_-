package dfs.unionSet;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    static boolean[] check;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int find01,find02;

    static boolean flag = false;
    public static void main(String[] args) {
        Main T = new Main();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // 인원 수
        check = new boolean[n+1]; // 체크용 배열

        for(int i =0 ; i<=n ; i++){
            list.add(new ArrayList<>()); // n개의 ArrayList 생성
        }

        int m = in.nextInt();
        for(int i=0 ; i< m ; i++){
            int p1 = in.nextInt();
            int p2 = in.nextInt();

            list.get(p1).add(p2);
            list.get(p2).add(p1);
            // 값 채워넣어주기
        }

        find01 = in.nextInt();
        find02 = in.nextInt();

        check[find01] =true;

        T.dfs(find01);
        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    private void dfs(int L) {
        if( list.get(L).isEmpty()) return ;
        else {
            if (list.get(L).contains(find02)) {
                flag = true;
                return;
            }
            for (int x : list.get(L)) {
                if( !check[x]) {
                    check[x] = true;
                    dfs(x);
                    check[x] = false;
                }
            }
        }
    }
}
