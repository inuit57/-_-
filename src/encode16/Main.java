package encode16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String input = in.next();

        int answer = Integer.parseInt(input, 16);
        System.out.println(answer);

    }

}
