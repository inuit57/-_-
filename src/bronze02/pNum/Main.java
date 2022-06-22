package bronze02.pNum;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String input = null ;
        while( input != "0"){
            input = in.next();
            if( input == "0") break;
            StringBuilder sb = new StringBuilder(input);
            if( sb.reverse().toString().equals(input)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }

}
