package stk_queue.bj3190;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {


    static int N ;
    static int[][] map ;
    static Deque<Point> snake = new ArrayDeque<>();
    static int dir = 0;
    public static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // 0 = 오른쪽
    // 1 = 아래쪽
    // 2 = 왼쪽
    // 3 = 위쪽
    // L 이동 시 : (dir+3)%4
    // R 이동 시 : (dir+1)%4
    static int[] px = {1,0,-1,0};
    static int[] py = {0,1,0,-1};

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        map = new int[N][N] ;

        int k = in.nextInt();
        for(int i =0 ; i< k ; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            map[y-1][x-1] = 1;
        }

        int l = in.nextInt();

        snake.add(new Point(0,0));

        int answer = 0;

        // input command ;
        answer = getAnswer(in, l, snake, answer);

//        System.out.println(snake.getFirst().x);
//        System.out.println(snake.getFirst().y);
//
//        System.out.println("dir : " + dir);

        while(isSafeMove(snake)){
            answer ++;
        }

        System.out.println(answer+1);
    }

    private static int getAnswer(Scanner in, int l, Deque<Point> snake, int answer) {
        for(int i = 0; i < l; i++) {
            int move = in.nextInt();
            char ch = in.next().charAt(0);

            for( ; answer < move ; answer++){
                if ( !isSafeMove(snake)) return answer;
            }

//            if( answer == move ){
//                System.out.println("answer : " + answer);
//                System.out.println(snake.getFirst().x);
//                System.out.println(snake.getFirst().y);
//            }

            if( ch == 'D'){
                dir = (dir +1)%4;
            }else {
                dir = (dir +3)%4;
            }
        }
        return answer;
    }

    /**
     * 뱀 이동시키는 함수
     * @param snake : 뱀
     * @return 0 : 끝, 1 : 지속 가능
     */
    private static boolean isSafeMove(Deque<Point> snake) {
        Point p = snake.peekFirst();
        int dx = p.x + px[dir];
        int dy = p.y + py[dir];

        if(isWall(dx, dy)){
            System.out.println("Wall!!");
            return false;
        }

        Point head = new Point(dx, dy);
        if( snake.contains(head)){
            System.out.println("SNAKE!");
            return false;
        }

        if(!eatApple(snake, dx, dy)){
            snake.removeLast(); // 끝 꼬리 줄임
        }

        // 새로운 머리를 앞에 넣기
        snake.addFirst(head);
        return true;
    }

    private static boolean eatApple(Deque<Point> snake, int dx, int dy) {
        if(map[dy][dx] == 1) {  // 과일 먹음
            map[dy][dx] = 0;
            return true;
        }
        return false;
    }

    private static boolean isWall(int dx, int dy) {
        return dx < 0 || dy < 0 || dx >= N || dy >= N;
    }

}
