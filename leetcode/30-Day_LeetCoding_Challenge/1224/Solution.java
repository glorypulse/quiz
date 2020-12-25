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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (next == null) break;
            prev.next = next;
            current.next = next.next;
            next.next = current;

            prev = current;
            current = current.next;
        }

        return dummy.next;
    }
}
