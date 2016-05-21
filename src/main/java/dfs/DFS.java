package dfs;

import com.google.common.collect.Lists;
import com.google.common.base.Objects;

import java.util.List;



/**
 * Created by wangzhenhua on 16/5/16.
 */
public class DFS {


    /**
     *
     * @param array
     * @param startNode
     * @param nodes
     */
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

    /**
     *
     * @param nodes
     * @param startNode
     * @param visitedNode
     */
    public static void travel(final List<Node> nodes,final Node startNode, final List<Node> visitedNode){

        if (Objects.equal(nodes.size(), visitedNode.size())) {
            return;
        }

        if ( !visitedNode.contains(startNode) ) {
            visitedNode.add(startNode);
        }

        List<Node> nodeList = startNode.getNodes();
        for ( Node node : nodeList ) {
            if ( !visitedNode.contains(node) ){
                visitedNode.add(node);
                travel(nodes,node,visitedNode);
            }
        }
    }

    public static void main(String[] args) {

        //构建有向图
        Node nodeA = new Node("a");
        Node nodeB = new Node("b");
        Node nodeC = new Node("c");
        Node nodeD = new Node("d");
        Node nodeE = new Node("e");
        Node nodeF = new Node("f");

        nodeA.put(nodeB);
        nodeA.put(nodeC);
        nodeA.put(nodeD);

        nodeB.put(nodeE);

        nodeD.put(nodeF);

        nodeE.put(nodeB);
        nodeE.put(nodeF);

        nodeF.put(nodeC);
        nodeF.put(nodeD);

        List nodes = Lists.newArrayList(nodeA,nodeB,nodeC,nodeD,nodeE,nodeF);

        List returnNodes = Lists.<Node>newLinkedList();
        DFS.travel(nodes, nodeA, returnNodes);
        System.out.println(returnNodes);

        returnNodes = Lists.<Node>newArrayList();
        DFS.travel(nodes, nodeB, returnNodes);
        System.out.println(returnNodes);



    }

}
