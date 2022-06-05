package sort.bubbleSort;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main T = new Main();

        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i< n; i++){
            arr[i] = in.nextInt();
        }

        int tmp =0 ;
        for(int i =0 ; i < n; i++){
            for(int j=0 ; j< n-1-i ; j++){
                if(arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1] ;
                    arr[j+1] = tmp ;
                }
            }
        }
        
        for(int i =0 ; i < n ; i++){
            System.out.print(arr[i] + " ");
        }
        return ;
    }
}
