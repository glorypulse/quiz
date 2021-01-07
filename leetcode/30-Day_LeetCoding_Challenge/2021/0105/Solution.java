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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                node = node.next;
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
            } else {
                prev.next = node;
                prev = node;
            }
            if (node != null) {
                node = node.next;
            }
        }
        prev.next = node;
        return dummy.next;
    }
}
