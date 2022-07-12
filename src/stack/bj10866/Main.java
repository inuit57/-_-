package stack.bj10866;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        Deque<Integer> deque = new ArrayDeque<>();

        int n = in.nextInt();
        in.nextLine();

        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i< n ; i++){
            String str = in.nextLine();
            String[] command = str.split(" ",2);

            switch(command[0]){
                case "push_back" : deque.addLast(Integer.parseInt(command[1]));break;
                case "push_front": deque.addFirst(Integer.parseInt(command[1]));break;
                case "front" :
                    if( !deque.isEmpty() ) {
                        sb.append(deque.getFirst());
                    }else{
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case "back" :
                    if( !deque.isEmpty() ) {
                        sb.append(deque.getLast());
                    }else{
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case "pop_front":
                    if( !deque.isEmpty() ) {
                        sb.append(deque.removeFirst());
                    }else{
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case "pop_back" :
                    if( !deque.isEmpty() ){
                        sb.append(deque.removeLast());
                    }else{
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case "size" :
                    sb.append(deque.size());
                    sb.append("\n");
                    break;
                case "empty" :
                    if(deque.isEmpty()){
                        sb.append("1");
                    }else{
                        sb.append("0");
                    }
                    sb.append("\n");
                    break;
            }// switch

        }

        System.out.println(sb);
    }

}
