/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        setFlatten(head);
        return head;
    }
    
    Node setFlatten(Node node) {
      if (node == null) return null;
      Node next = node.next;
      if (node.child != null) {
        Node child = node.child;
        node.next = child;
        node.child = null;
        child.prev = node;
        node = setFlatten(child);
        node.next = next;
        if (next != null) {
          next.prev = node;
        }
      }
      if (next == null) return node;
      return setFlatten(node.next);
    }
}