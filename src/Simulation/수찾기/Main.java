package Simulation.수찾기;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(in.nextInt());
        }

        StringBuilder sb = new StringBuilder();
        int M = in.nextInt();
        for (int i = 0; i < M; i++) {
            if (!set.add(in.nextInt())) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
