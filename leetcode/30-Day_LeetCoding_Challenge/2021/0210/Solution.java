/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        return createNewNode(head, map);
    }

    Node createNewNode(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        newNode.next = createNewNode(node.next, map);
        newNode.random = map.get(node.random);
        return newNode;
    }
}
