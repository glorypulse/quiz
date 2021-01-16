/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode ret;
        if (l1.val <= l2.val) {
            ret = new ListNode(l1.val);
            ret.next = mergeTwoLists(l1.next, l2);
        } else {
            ret = new ListNode(l2.val);
            ret.next = mergeTwoLists(l1, l2.next);
        }

        return ret;
    }
}
