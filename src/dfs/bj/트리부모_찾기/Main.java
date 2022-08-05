package dfs.bj.트리부모_찾기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<Integer,Integer> tree = new HashMap<>();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] arr = new int[n+1][n+1];

        arr[1][1] = 1;
        tree.put(1,1);

        for(int i= 0; i< n-1 ; i++){
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            arr[num1][num2] = 1;
            arr[num2][num1] = 1;
        }



        ArrayList<Integer> list = new ArrayList<>();
        for(int next = 2; next<= n ; next++){
            if( arr[1][next] == 1 ){
                tree.put(next, 1);
                list.add(next);
            }
        }

        findParent(n, arr,  list);

        for(int i =2 ; i<= n ; i++){
            System.out.println(tree.get(i));
        }
    }

    private static void findParent(int n, int[][] arr, ArrayList<Integer> list) {
        if( tree.size() == n ) return;

        ArrayList<Integer> nextList = new ArrayList<>();
        for(int num : list){
            for(int next = 2; next <= n; next++){
                if(arr[num][next] == 1){
                    if( tree.get(next) == null ) {
                        tree.put(next, num);
                        nextList.add(next);
                    }
                }
            }
        }

        if( tree.size() < n ){
            findParent(n,arr, nextList);
        }
    }

}
