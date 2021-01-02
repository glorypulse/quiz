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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = getMiddle(head);

        first = sortList(first);
        second = sortList(second);

        ListNode node = new ListNode();
        ListNode ans = node;

        while (first != null || second != null) {
            if (second == null || first != null && first.val <= second.val) {
                node.next = first;
                first = first.next;
            } else {
                node.next = second;
                second = second.next;
            }
            node = node.next;
        }
        node.next = null;
        return ans.next;
    }

    ListNode getMiddle(ListNode node) {
        ListNode pre = node;
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }


}
