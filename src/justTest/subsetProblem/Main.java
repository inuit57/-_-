package justTest.subsetProblem;

public class Main {

    public static void main(String[] args){
        Main T = new Main();
        int[] input = {1,2,3,4};
        int N = 4;
        int min = 5;
        int max = 6;
        int answer = T.solution(input, N,min,max);

        // 0(아무것도 고르지않음) , 1, 2, 3 (1+2)

        System.out.println(answer);
    }

    public int solution(int[] input,int N,  int min, int max ){
        int answer = 0;

        for(int i= 0 ; i< (1<<N) ; i++){
            int sum = 0 ;
            for(int j=0 ; j< N ; j++){ // 자릿수별...체크가 되겠네.
                // j = 0,1,2,3
                // 00, 01

                if( (i & (1<<j) ) != 0  ){
                    //System.out.println(input[j]);
                    sum += input[j] ;
                }
            }
            if( sum >= min && sum <= max){
                answer ++;
            }
        }
        return answer ;
    }
}
