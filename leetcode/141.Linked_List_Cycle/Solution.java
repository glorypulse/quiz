/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode node = head;
        ListNode nodeFaster = head.next;

        while (node != null && nodeFaster != null && nodeFaster.next != null) {
            if (node == nodeFaster) return true;
            node = node.next;
            nodeFaster = nodeFaster.next.next;
        }

        return false;
    }
}
