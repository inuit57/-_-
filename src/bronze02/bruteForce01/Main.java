package bronze02.bruteForce01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int answer = 0 ;
        for(int i = 1; i <= n ; i++){
            int sum = getSum(i);
            if( sum == n){
                answer = i ;
                break;
            }
        }

        System.out.println(answer);
    }

    private static int getSum(int i) {
        int check = i;
        int sum = i;
        while(check / 10 != 0){
            sum += check%10;
            check /= 10;
        }
        sum += check%10;
        return sum;
    }

}
