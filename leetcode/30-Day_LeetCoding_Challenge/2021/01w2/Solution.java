/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        if (tree.isEmpty()) return null;
        Set<Integer> childrenSet = new HashSet<>();
        Map<Integer, Node> valueMap = new HashMap<>();
        for (Node node: tree) {
            for (Node child: node.children) {
                childrenSet.add(child.val);
                if (valueMap.containsKey(child.val)) {
                    valueMap.remove(child.val);
                }
            }

            if (!childrenSet.contains(node.val)) {
                valueMap.put(node.val, node);
            }
        }
        Node head = null;
        for (Node node: valueMap.values()) {
            head = node;
        }
        return head;
    }
}
