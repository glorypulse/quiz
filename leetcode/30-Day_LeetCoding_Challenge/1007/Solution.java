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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int size = stack.size();
        k = k % size - 1;
        if (k < 0) return head;

        node = stack.pop();
        node.next = head;
        while (k > 0) {
            node = stack.pop();
            k --;
        }
        ListNode ans = node;
        node = stack.pop();
        node.next = null;
        return ans;
    }
}
