package DP.bj12852;

import java.util.Scanner;

public class Main {

    static class Record{
        int cnt;
        String process ;
        public Record(int cnt , String process){
            this.cnt = cnt;
            this.process = process;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();


        int n = in.nextInt();

        Record[] records = new Record[n+1] ;

        records[1] = new Record(0,"1") ; // 최초값
        for(int i =2; i<= n ; i++){
            int cnt = Integer.MAX_VALUE;
            int before = 0;
            if( i%3 == 0 ){
                cnt = records[i/3].cnt;
                before = i/3;
            }

            if(i%2 == 0){
                if( cnt > records[i/2].cnt){
                    cnt = records[i/2].cnt;
                    before = i/2;
                }
            }

            if( cnt > records[i-1].cnt){
                cnt = records[i-1].cnt;
                before = i-1;
            }

            records[i] = new Record(cnt +1,i+" "+records[before].process );
        }

        System.out.println(records[n].cnt);
        System.out.println(records[n].process);
    }


}
