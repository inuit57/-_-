package devide01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        long input = in.nextLong();
        int f = in.nextInt();

        long k = (input/100) * 100 ;

        for(int i=0 ; i < 100 ; i++){
            if( (k+i)%f == 0){
                if( i < 10 ) System.out.print(0);
                System.out.println(i);
                break;
            }
        }


    }

}
