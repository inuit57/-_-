package justTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] arr = new int[1001] ;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        List<Integer> users = new ArrayList<>();
        int n = in.nextInt();
        for(int i =0 ; i< n; i++){
            users.add(in.nextInt());
        }

        Collections.sort(users);
//        printList(users);

        int answer = 0 ;
        for(int i=0; i< n ;i++){
            answer += users.get(i) * (n-i);
        }

        System.out.println(answer);
    }

    private static void printList(List<Integer> users) {
        for(int aaa : users){
            System.out.println(aaa);
        }
    }


}
