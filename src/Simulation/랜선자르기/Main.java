package Simulation.랜선자르기;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


    static int[] arr ;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s =bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Main T = new Main();

        // 입력 받기
        long avg = 0 ;
        arr = new int[k] ;
        for(int i=0; i< k; i++){
            int tmp = Integer.parseInt(bf.readLine()) ;
            arr[i] = tmp;
            avg += tmp ;
        }

        avg /= k ; // 평균값으로 시도
        System.out.println(T.solution(avg,n) );
    }

    public long solution(long avg, int n  ){
        long stt , end , cnt = 0   ;
        stt = 0 ;
        end = avg ;

        while( stt < end ){
            long mid = (stt+end)/2 ;
            cnt = getCount(mid);
            if( cnt < n ){
                end = mid-1 ;
            }else{
                stt = mid ;
            }
        }
        return stt;
    }


    public int getCount(long len ){
        int count = 0 ;
        for(int a : arr){
            count += (a/len) ;
        }
        return count;
    }
}
