package dfs.bj.bj9019;

import java.util.*;

public class Main {

    static int answerCnt  ;
    static String answer ;
    static int tobe ;

    static class Data{
        int number;
        String answer ;

        public Data(int number, String str){
            this.number = number;
            this.answer = str;
        }

    }

    static boolean[] check = new boolean[10001];

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        StringBuilder sb = new StringBuilder();
        int n = in.nextInt();
        for(int i =0 ; i< n; i++){
            int asis = in.nextInt();
            tobe = in.nextInt();

            // 초기화 수행
            answerCnt = 10 ;
            answer = "" ;

            Queue<Data> queue = new LinkedList<>();

            queue.add(new Data(asis,""));
            check[asis] = true;

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int j =0; j< size ; j++){
                    Data data = queue.poll();
                    int aa = data.number;
                    String ans = data.answer;

                    if( aa == tobe){
                        queue.clear();
                        sb.append(ans);
                        sb.append("\n");
                        break;
                    }

                    int d = T.calc_D(aa);
                    int s = T.minus(aa);
                    int l = T.rotate(aa,true);
                    int r = T.rotate(aa, false);

                    if( !check[d]){
                        check[d] = true;
                        queue.add(new Data(d, ans +"D"));
                    }
                    if( !check[s]){
                        check[s] = true;
                        queue.add(new Data(s, ans+"S"));
                    }
                    if( !check[l]){
                        check[l] = true;
                        queue.add(new Data(l, ans+"L"));
                    }
                    if( !check[r]){
                        check[r] = true;
                        queue.add(new Data(r, ans+"R"));
                    }
                } // for end
            }

        }
        System.out.println(sb);

    }

    /**
     * 회전시키기 
     * @param number 회전시킬 숫자
     * @param dir 회전 방향,  Left : true, right : false
     * @return
     */
    private int rotate(int number, boolean dir){
        if( number == 0) return 0;
        int tmp ;
        if(dir){
            tmp = number % 1000;
            tmp *=10;
            tmp += number/1000 ;
        }else{
            tmp = number /10;
            tmp += (number%10) * 1000;
        }
        return tmp ;
    }

    private int minus(int number){
        return number == 0 ? 9999 : number -1;
    }

    private int calc_D(int number){
        return (number*2)%10000;
    }

}
