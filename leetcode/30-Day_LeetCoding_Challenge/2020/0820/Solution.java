/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head.next;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int size = stack.size();
        node = head;
        int i = 0;
        while (i < size) {
            ListNode tmp = node.next;
            node.next = stack.pop();
            node = node.next;
            i ++;
            if (i == size) break;

            node.next = tmp;
            node = node.next;
            i ++;
        }
        node.next = null;
    }
}
