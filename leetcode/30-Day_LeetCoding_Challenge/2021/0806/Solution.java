/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ansList = new ArrayList<>();
        setValue(root, 0, ansList);
        return ansList;
    }

    void setValue(Node node, int depth, List<List<Integer>> list) {
        if (node == null) return;
        if (list.size() == depth) {
            list.add(new ArrayList<>());
        }
        list.get(depth).add(node.val);
        for (Node child: node.children) {
            setValue(child, depth + 1, list);
        }
    }
}
