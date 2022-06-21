package countingSort;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] sortArr = new int[10001];


        int n = Integer.parseInt(br.readLine());
        for(int i =0 ; i< n ;i++){
            sortArr[Integer.parseInt(br.readLine())] ++ ;
        }

        for(int i = 1; i<= 10000; i++){
            for(int j =0 ; j < sortArr[i] ; j++){
               bw.write(i + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

}
