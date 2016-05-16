
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangzhenhua on 16/5/16.
 */
public class DFS {


    public static void travel(int[][] array,int startNode,List<Integer> nodes){

        if (nodes.size() == array.length){
            return;
        }

        for (int i = startNode; i <array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                 int ifCanBeAccess = array[i][j];
                 if ( ifCanBeAccess == 1 &&
                      !nodes.contains(j)  ) {
                     nodes.add(j);
                     travel(array, j, nodes);
                 }else {
                     continue;
                 }
            }
        }
    }

    public static void main(String[] args) {
        int array[][] = {
                {0,1,1,0,0,0,1},
                {1,0,0,1,0,1,0},
                {1,0,0,0,1,0,0},
                {0,1,0,0,1,1,0},
                {0,1,0,1,0,1,0},
                {0,1,0,1,1,0,0},
                {1,0,0,0,0,0,0}
        };
        java.util.List<Integer> nodes = new LinkedList<Integer>();
        DFS.travel(array,2,nodes);
        System.out.println(nodes);
    }

}
