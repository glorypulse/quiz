import java.util.ArrayList;

class Node {
    public String name;
    public ArrayList<Node> nextNodes;

    public Node(String name) {
        this.name = name;
        this.nextNodes = new ArrayList<Node>();
    }

    public void setNextNode(Node node) {
        nextNodes.add(node);
    }
}
