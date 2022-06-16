package dfs.bj.bj1759;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static boolean[] check ;
    static int L, C ;
    static ArrayList<Character> alphaList = new ArrayList<>();

    static String answer = "";

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        L = in.nextInt();
        C = in.nextInt();


        in.nextLine(); // 엔터 지우기
        String line = in.nextLine();
        String[] strings = line.split(" ");

        for(String str : strings){
            alphaList.add(str.charAt(0));
        }
        Collections.sort(alphaList);
        // 입력 처리 끝

        //printArr();


        check = new boolean[C];
        T.dfs(0,0,0,0);
    }

    private static void printArr() {
        for(char ch : alphaList){
            System.out.print(ch);
        }
        System.out.println();
    }

    /**
     * 
     * @param l  : 현재 글자 갯수
     * @param aa : 모음 갯수
     * @param bb : 자음 갯수
     */
    private void dfs(int curr, int l, int aa, int bb) {
        if( l > L ) return;
        if(l == L  && aa >=1 && bb >=2){
            String str = "";
            for(int i=0 ; i< C ;i++){
                if(check[i]) str += alphaList.get(i); //System.out.print(alphaList.get(i));
            }
            System.out.println(str);
            return;
        }

        if( curr < C) {
            // 현재 위치 값을 넣는 경우
            check[curr] = true;
            if (isAA(alphaList.get(curr))) {
                dfs(curr + 1, l + 1, aa + 1, bb);
            } else {
                dfs(curr + 1, l + 1, aa, bb + 1);
            }
            check[curr] = false;
            dfs(curr + 1, l, aa, bb); // 넣지 않는 경우
        }
    }

    private boolean isAA(char ch){
        return "aeoui".indexOf(ch) >= 0 ;
    }
}
