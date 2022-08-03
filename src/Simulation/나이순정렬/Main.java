package Simulation.나이순정렬;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Member> members = new ArrayList<>();

        for(int i =0; i< N ; i++){
            int age = in.nextInt();
            String name = in.next();
            members.add(new Member(i,age,name));
        }

        members.sort((o1, o2) -> o1.age == o2.age ? o1.idx - o2.idx : o1.age - o2.age);

        StringBuilder sb = new StringBuilder();
        for(Member m : members){
            sb.append(m.age);
            sb.append(" ");
            sb.append(m.name);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Member{
        int idx;
        int age;
        String name ;
        public Member(int idx,int age,String name){
            this.idx = idx ;
            this.age = age ;
            this.name = name;
        }
    }
}


