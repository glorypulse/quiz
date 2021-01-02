/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Node root = new Node(node.val);
        ArrayList<Node> nodes = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        nodes.add(root);
        setNodes(node, root, nodes, visited);
        return root;
    }

    void setNodes(Node orig, Node newNode, ArrayList<Node> nodes, Set<Node> visited) {
        if (visited.contains(orig)) return;
        visited.add(orig);
        for (Node neighbor: orig.neighbors) {
            if (neighbor.val > nodes.size()) {
                for (int i = nodes.size() + 1; i <= neighbor.val; i ++) {
                    nodes.add(new Node(i));
                }
            }
            Node newNeighbor = nodes.get(neighbor.val - 1);
            newNode.neighbors.add(newNeighbor);
            setNodes(neighbor, newNeighbor, nodes, visited);
        }
    }
}
