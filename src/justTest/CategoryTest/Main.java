package justTest.CategoryTest;


import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class CategoryNode {
        String name ;
        int cnt ;
        List<CategoryNode> next = new LinkedList<>();

        CategoryNode(String name, int cnt){
            this.name = name;
            this.cnt = cnt;
        }

        public void addCategoryNode(CategoryNode node){
            if( node != null ) this.next.add(node);
        }

        public StringBuilder printCate(StringBuilder sb, int depth ){
            if( depth > 0 ){
                sb.append("ㄴ");
                sb.append("--".repeat(depth-1));
                //for(int i =1 ;i< depth ; i++) sb.append("--");
                sb.append(">");
            }

            sb.append(this.name);
            sb.append("(").append(cnt).append(")");

            if( this.next.size() > 0 ){
                for(CategoryNode cn : next){
                    sb.append("\n");
                    cn.printCate(sb, depth +1);
                }
            }
            //System.out.println(sb);
            return sb;
        }
    }

    public static void main(String[] args){

        Map<String, CategoryNode> map = new HashMap<>();

        // depth = 1
        String cate1 = "게시판" ;
        String cate2 = "업무" ;

        CategoryNode c1 = new CategoryNode(cate1, 10);
        CategoryNode c2 = new CategoryNode(cate2, 20);

        map.put(cate1, c1);
        map.put(cate2, c2);

        // depth = 2;
        addCategory(map, "게시판 > 알림사항" , 1,4);
        addCategory(map, "업무 > 유지보수" , 1,10);
        addCategory(map, "업무 > 추가개발" , 1,8);

        addCategory(map, "업무 > 추가개발 > 테스트" , 2,3);
        addCategory(map, "업무 > 추가개발 > 고도화" , 2,5);

//        map.get(strList_20[0]).addCategoryNode(c_20);
//        map.get(strList_21[0]).addCategoryNode(c_21);

        System.out.println(c1.printCate(new StringBuilder() ,0 ) );
        System.out.println(c2.printCate(new StringBuilder() ,0 ) );


//        c2.printCate(new StringBuilder());

    }

    private static void addCategory(Map<String, CategoryNode> map, String cateName, int depth, int count ) {
        List<String> tmpList = Arrays.stream(cateName.split(">")).map(String::trim).collect(Collectors.toList());
        String currName = tmpList.get(depth) ;
        CategoryNode cn = new CategoryNode(currName,count);
        map.get(tmpList.get(depth-1)).addCategoryNode(cn);
        map.put(currName,cn);
    }

}
