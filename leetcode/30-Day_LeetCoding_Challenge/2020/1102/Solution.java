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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode ans = new ListNode(); // dummy
        ans.next = head;
        ListNode node = head.next;
        head.next = null;
        ListNode prev = ans;
        ListNode next = null, output;

        if (node != null) {
            next = node.next;
            node.next = null;
        }

        while (node != null) {
            output = prev.next;

            if (output == null || node.val < output.val) {
                prev.next = node;
                node.next = output;
                node = next;
                if (node != null) {
                    next = node.next;
                    node.next = null;
                }
                prev = ans;
            } else {
                prev = output;
            }
        }

        return ans.next;
    }
}
