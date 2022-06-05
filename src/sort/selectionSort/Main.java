package sort.selectionSort;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main T = new Main();

        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i< n; i++){
            arr[i] = in.nextInt();
        }

        for(int i =0 ; i < n; i++){
            int min = Integer.MAX_VALUE ;
            int min_idx = i;
            for(int j =i+1 ; j< n ; j++){
                if( min > arr[j] ){
                    min = arr[j] ;
                    min_idx = j;
                }
            }
            if( min < arr[i]) {
                int tmp = arr[i];
                arr[i] = min;
                arr[min_idx] = tmp;
            }
        }
        
        for(int i =0 ; i < n ; i++){
            System.out.print(arr[i] + " ");
        }
        return ;
    }
}
