import java.util.LinkedList;
import java.util.HashMap;

class Graph {
    public HashMap<String, Node> nodes;

    public Graph() {
        nodes = new HashMap<String, Node>();
    }

    public Graph(Node[] nodes_array) {
        this();
        setNodes(nodes_array);
    }


    public void setNode(Node node) {
        nodes.put(node.name, node);
    }

    public void setNodes(Node[] nodes_array) {
        for (Node node: nodes_array) {
            setNode(node);
        }
    }

    // Graph, Node classを仮定する
    public boolean hasRoutes(Node start, Node end) {
        if (start == end) return true;

        // BFSで探索する
        LinkedList<Node> searchQueue = new LinkedList<Node>();
        searchQueue.addAll(start.nextNodes);

        // 訪問フラグ
        HashMap<String, State> visitedNodes = new HashMap<String, State>() {
                {
                    for (Node node: start.nextNodes) {
                        put(node.name, State.Visiting);
                    }
                }
            };


        while (!searchQueue.isEmpty()) {
            Node current = searchQueue.removeFirst();
            if (current == end) return true;
            visitedNodes.put(current.name, State.Visited);
            for (Node node: current.nextNodes) {
                if (visitedNodes.get(node.name) == null) {
                    visitedNodes.put(node.name, State.Visiting);
                    searchQueue.add(node);
                }
            }
        }

        return false;
    }

    private enum State {
        UnVisited, Visiting, Visited
    }

}
