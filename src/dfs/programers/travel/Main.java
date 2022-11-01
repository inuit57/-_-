package dfs.programers.travel;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[][] input = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},{"ATL","SFO"}} ;

        for(String s : solution(input)){
            System.out.println(s);
        }
    }

    static class Ticket{
        String city ;
        int index ;

        public Ticket(String ep, int idx){
            this.city = ep;
            this.index = idx;
        }

    }
    static Map<String,List<Ticket>> map = new HashMap<>();
    static boolean[] visits ;
    static List<String> answerList = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    static String answerTemp = null ;

    public static void dfs(int depth, String next){

        if( depth == visits.length ){

            // 새로 구해진 답안
            for(String str : answerList) {
                sb.append(str);
                sb.append(" ");
            }
            //answer = answerList.toArray(String[]::new);
            if( answerTemp == null ) answerTemp = sb.toString();
            else if(answerTemp.compareTo(sb.toString()) > 0 ) {
                // 사전 순으로 더 뒤라면 answerTemp 를 바꿔줘야 한다.
                answerTemp = sb.toString();
            }
        }

        // 방문할 지점을 맵에서 구한다.
        List<Ticket> cities = map.getOrDefault(next,new ArrayList<>());

        for(int i=0; i< cities.size(); i++){
            String nextCity = cities.get(i).city;
            int idx = cities.get(i).index;

            if(visits[idx]) continue;

            visits[idx] = true;
            answerList.add(nextCity);
            dfs(depth+1, nextCity); // 해당 지역으로 진행
            visits[idx] = false;
            answerList.remove(nextCity);
        }

    }

    public static String[] solution(String[][] tickets) {

        // 항공권을 모두 사용해야 한다. (항공권 사용 여부만 확인한다.)
        // 도시 방문 체크는 그래서 중요하지 않다.
        visits = new boolean[tickets.length];


        for(int i=0; i< tickets.length ; i++){
            List<Ticket> list = map.getOrDefault(tickets[i][0], new ArrayList<Ticket>());
            list.add(new Ticket(tickets[i][1],i));
            map.put(tickets[i][0], list);
        }

        for(String key : map.keySet()){
            Collections.sort(map.get(key), (a,b)->(a.city.compareTo(b.city))); // 정렬
        }

        for(String key : map.keySet()){
            System.out.print(key + ":");
            for(Ticket value : map.get(key)){
                System.out.print(value.city+" ");
            }
            System.out.println();
        }
        System.out.println("------");

        answerList.add("ICN");
        dfs(0,"ICN");

        String[] answer = answerTemp.split(" ");
        return answer;
    }
}
