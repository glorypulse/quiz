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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode node = l1;
        while (node != null) {
            stack1.push(node.val);
            node = node.next;
        }
        node = l2;
        while (node != null) {
            stack2.push(node.val);
            node = node.next;
        }

        node = null;
        int prev = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val1 = 0, val2 = 0;
            if (!stack1.isEmpty()) {
                val1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                val2 = stack2.pop();
            }

            ListNode tmp = new ListNode((val1 + val2 + prev) % 10);
            if (val1 + val2 + prev >= 10) {
                prev = 1;
            } else {
                prev = 0;
            }

            tmp.next = node;
            node = tmp;
        }

        if (prev == 1) {
            ListNode tmp = new ListNode(prev);
            tmp.next = node;
            node = tmp;
        }

        return node;
    }
}
