package greedy.bj1541;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String str = in.next();

        Function<String,Integer> parseInt = Integer::parseInt;

        String[] minusArr = str.split("-");

        List<Integer> list = new ArrayList<>();

        for(String s : minusArr){
            String[] split = s.split("\\+");
            int sum = 0;
            for(String sp : split){
                sum += parseInt.apply(sp);
            }
            list.add(sum);
        }

        int answer = list.get(0) ;
        for(int i =1 ; i < list.size(); i++){
            answer -= list.get(i);
        }

        System.out.println(answer);
    }

}
