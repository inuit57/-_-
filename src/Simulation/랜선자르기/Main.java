package Simulation.랜선자르기;

import java.awt.*;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


    /**
     * 예외 테스트 케이스
     * 4 1
     * 802
     * 743
     * 457
     * 539
     */
    static int[] arr ;

    public static void main(String[] args) throws IOException {

//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String s =bf.readLine();
//        StringTokenizer st = new StringTokenizer(s);
//        int k = Integer.parseInt(st.nextToken());
//        int n = Integer.parseInt(st.nextToken());

        // 스캐너 입력 테스트
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();

        Main T = new Main();

        // 입력 받기
        long max = Integer.MIN_VALUE ;
        arr = new int[k] ;
        for(int i=0; i< k; i++){
            //int tmp = Integer.parseInt(bf.readLine()) ;
            int tmp = in.nextInt();
            arr[i] = tmp;
            max = Math.max(max, tmp);
        }

        long answer  = T.solution(max,n);
        System.out.println(answer );
    }

    public long solution(long max, int n  ){
        long answer = 0;

        long stt , end , cnt   ;
        stt = 0 ;
        end = max ;
        long mid = max ; // 1개만 뽑아내는 예외케이슷 고려, 최댓값으로 첫시도하기
        while( stt < end ){
            cnt = getCount(mid);
            if( cnt < n ){
                end = mid ;
            }else{
                answer = Math.max(mid, answer);
                stt = mid +1;
            }
            mid = (stt+end)/2 ;
        }

        return answer;
    }



    public int getCount(long len ){
        int count = 0 ;
        for(int a : arr){
            count += (a/len) ;
        }
        return count;
    }
}
