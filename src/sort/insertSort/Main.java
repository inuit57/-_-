package sort.insertSort;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Main T = new Main();

        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i< n; i++){
            arr[i] = in.nextInt();
        }

        int tmp =0 ;
        int j,key ;
        for(int i =1 ; i < n; i++){
            key = arr[i];
            for(j=i-1; j>=0 ; j--){
                if( arr[j] > key) {
                    arr[j + 1] = arr[j]; // 레코드의 오른쪽으로 이동
                }
                else {
                    break;
                }
            }
            arr[j+1] = key;
        }
        
        for(int i =0 ; i < n ; i++){
            System.out.print(arr[i] + " ");
        }

        return ;
    }
}
