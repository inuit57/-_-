package test06;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(T.solution(n,k));

    }

    private int solution(int n, int k) {

        int[] arr = new int[n+1] ;

        int remove = 0;
        arr[0] = 1;
        for (int i = 0; i < n-1 ; i++) {
            for (int j = 0; j < k; j++) {
                remove = (remove + 1) % (n+1);
                while (arr[remove] == 1) {
                    remove = (remove + 1) % n;
                }
            }
            System.out.println("remove[" + i + "] = " + remove);
            arr[remove] = 1;
        }

        for(int i = 1 ; i<= n; i++){
            if( arr[i] == 0){
                return  i;
            }
        }

        return  remove ;
    }
}
