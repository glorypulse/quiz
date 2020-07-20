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
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return head;

        ListNode node = head;
        while (node != null && node.next != null) {
            ListNode next = node.next;
            while (next != null && next.val == val) {
                next = next.next;
            }
            node.next = next;
            node = next;
        }
        return head;
    }
}
