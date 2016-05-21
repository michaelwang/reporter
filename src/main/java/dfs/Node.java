package dfs;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

public class Node {

    private final String nodeName;

    private final List<Node> nodes = Lists.newArrayList();

    public Node(String nodeName) {
        this.nodeName = nodeName;
    }

    public boolean put(Node node){
       return nodes.add(node);
    }

    public String getNodeName() {
        return nodeName;
    }

    public List<Node> getNodes() {
        return Lists.newArrayList(nodes);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equal(nodeName, node.nodeName) &&
                Objects.equal(nodes, node.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nodeName);
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeName='" + nodeName + '\'' +
                '}';
    }


}
