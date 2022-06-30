package justTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String input = in.next();

        String[] splits = input.split("_" ,3);
        for (String split : splits) {
            if( split == null) System.out.println("!!!");
            System.out.println("1 : " + split);
        }
    }

}
