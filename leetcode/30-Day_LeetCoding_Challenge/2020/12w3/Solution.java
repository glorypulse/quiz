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
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            if (node.val < 9) {
                while (!stack.isEmpty()) stack.pop();
            }
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            node.val += 1;
            if (node.val <= 9) {
                break;
            } else {
                node.val -= 10;
                if (stack.isEmpty()) {
                    head = new ListNode(1, node);
                }
            }
        }

        return head;
    }
}
