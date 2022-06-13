package union_find;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static class Edge {
        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        int v1,v2,cost;
    }

    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] unf ;

    public static int find(int v){
        if( v == unf[v] ) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if( fa != fb) unf[fa] = fb ;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int v = in.nextInt(); // 도시의 갯수
        int e = in.nextInt(); // 도로의 갯수

        unf = new int[v+1] ;
        for(int i=1 ; i< v+1; i++){
            unf[i] = i;
        }

        for(int i= 0; i< e; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int cost = in.nextInt();
            edges.add(new Edge(v1,v2,cost));
        }

        Collections.sort(edges,(e1,e2)->e1.cost - e2.cost);

        int answer = 0 ;
        for(Edge edge : edges){
            if( find(edge.v1) != find(edge.v2)){
                union(edge.v1, edge.v2);
                answer += edge.cost;
            }
        }
        System.out.println(answer);
    }
}
