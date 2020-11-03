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
    public int getDecimalValue(ListNode head) {
        int val = 0;
        ListNode node = head;
        while (node != null) {
            val <<= 1;
            if (node.val == 1) {
                val ++;
            }
            node = node.next;
        }
        return val;
    }
}
