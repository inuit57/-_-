package justTest;

import java.util.Scanner;

public class Main {

    static int[] arr = new int[1001] ;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int input = in.nextInt();
//        System.out.println(fibo(input));
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 3;

        for(int i = 3; i<= 1000 ; i++){
            arr[i] = ( arr[i-2]*2 + arr[i-1] ) % 10007 ;
        }
        System.out.println(arr[input]);
    }

//    public static int fibo(int n){
//        if( arr[n] != 0) return arr[n] ;
//        if( n == 0 || n == 1) {
//            return arr[n] = 1 ;
//        }else{
//            if( arr[n-1] == 0) arr[n-1] = fibo(n-1) %10007;
//            if( arr[n-2] == 0) arr[n-2] = fibo(n-2) %10007;
//
//            return arr[n] = (arr[n-1] + arr[n-2])%10007 ;
//        }
//    }

}
