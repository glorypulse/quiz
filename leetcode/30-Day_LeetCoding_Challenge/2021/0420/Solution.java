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
    public List<Integer> preorder(Node root) {
        List<Integer> preorderList = new ArrayList<>();
        if (root == null) return preorderList;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            preorderList.add(node.val);
            if (!node.children.isEmpty()) {
                Stack<Node> revStack = new Stack<>();
                for (Node child: node.children) {
                    revStack.push(child);
                }
                while (!revStack.isEmpty()) {
                    stack.push(revStack.pop());
                }
            }
        }
        return preorderList;
    }
}
